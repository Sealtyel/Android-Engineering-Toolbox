package sealtyel.example.com.engineeringtoolbox.subnetting;

import android.util.Log;

/**
 * Created by mayra.
 */
public class OperacionesRedes {

    String red;
    String subRedes;
    String matrizResultados[][];

    public String[][] generarActionPerformed(String redP, int[] array)
    {

        matrizResultados=new String[array.length][6];
        int arrayNoNodo[] = ordenarArray(array);
        String temp="";

        for(int i=0;i<arrayNoNodo.length;i++)
            temp=temp+arrayNoNodo[i]+" ";

        this.red = String.valueOf(redP);
        this.subRedes = String.valueOf(temp);

        int[] mascaraSubred = { 0, 0, 0, 0, 0 };

        String[] redNumerosStr = this.red.split("\\.");
        int[] redNumeros = new int[4];
        convertirStringInt(4, redNumerosStr, redNumeros);

        String[] subRedesNumerosStr = this.subRedes.split("\\s+");
        int[] subRedesNumeros = new int[subRedesNumerosStr.length];
        convertirStringInt(subRedesNumerosStr.length, subRedesNumerosStr, subRedesNumeros);

        int band = 0;
        for (int i = 0; i < redNumeros.length; i++) {
            if ((redNumeros[i] > 255) || (redNumeros[i] < 0))
                band = 1;
        }

        for (int i = 0; i < subRedesNumeros.length; i++)
        {
            if ((subRedesNumeros[i] > Math.pow(2.0D, 24.0D)) || (subRedesNumeros[i] < 3))
                band = 1;
        }

        for (int indice = 0; (indice < subRedesNumerosStr.length) && (band == 0); indice++)
        {
            int numeroBits = calcularNumerodeBitsRepresentarSudred(subRedesNumeros[indice])+1;

            String segundoOctal = convertirIntBinario(redNumeros[1]);
            String tercerOctal = convertirIntBinario(redNumeros[2]);
            String cuartoOctal = convertirIntBinario(redNumeros[3]);
            boolean breakLoop = false;
            if (numeroBits < 8)
            {
                for (int i = 7; 7 - i < numeroBits; i--)
                {
                    if (cuartoOctal.charAt(i) != '0')
                        breakLoop = true;
                }
            }
            else if (numeroBits < 16) {
                breakLoop = cuartoOctal.equals("00000000") != true;
                for (int i = 7; 7 - i < numeroBits - 8; i--)
                {
                    if (tercerOctal.charAt(i) != '0')
                        breakLoop = true;
                }
            }
            else if (numeroBits < 24) {
                breakLoop = (cuartoOctal.equals("00000000") != true) || (tercerOctal.equals("00000000") != true);
                for (int i = 7; 7 - i < numeroBits - 16; i--)
                {
                    if (segundoOctal.charAt(i) != '0') {
                        breakLoop = true;
                    }
                }
            }
            if (breakLoop == true) {
               break;
            }


            //direccion red
            matrizResultados[indice][0] = redNumeros[0] + "." + redNumeros[1] + "." + redNumeros[2] + "." + redNumeros[3] + " /" + (32 - numeroBits);
            //longitud
            matrizResultados[indice][1] = subRedesNumeros[indice]+"";
            //host minimo
            matrizResultados[indice][2] = redNumeros[0] + "." + redNumeros[1] + "." + redNumeros[2] + "." + (redNumeros[3] + 1);
            calcularMascaraSubred(numeroBits, mascaraSubred);
            calcularHostMax(numeroBits, redNumeros);
            //host maximo
            matrizResultados[indice][3] =redNumeros[0] + "." + redNumeros[1] + "." + redNumeros[2] + "." + redNumeros[3];
            //mascara de red
            matrizResultados[indice][4] = mascaraSubred[0] + "." + mascaraSubred[1] + "." + mascaraSubred[2] + "." + mascaraSubred[3];
            if (redNumeros[3] == 255) {
                if (redNumeros[2] == 255)
                {
                    if (redNumeros[1] == 255)
                    {
                        redNumeros[0] += 1;
                        redNumeros[1] = 0;
                        redNumeros[2] = 0;
                        redNumeros[3] = 0;
                    }
                    else {
                        redNumeros[1] += 1;
                        redNumeros[2] = 0;
                        redNumeros[3] = 0;
                    }
                } else {
                    redNumeros[2] += 1;
                    redNumeros[3] = 0;
                }
            }
            else {
                redNumeros[3] += 1;
            }

            mascaraSubred = new int[] { 0, 0, 0, 0, 0 };
        }

        return matrizResultados;
    }

    private void convertirStringInt(int longitud, String[] vectorStr, int[] vectorNumeros)
    {
        for (int j = 0; j < longitud; j++)
            vectorNumeros[j] = Integer.parseInt(vectorStr[j]);
    }

    private int calcularNumerodeBitsRepresentarSudred(int subRedesNumeros)
    {
        int result = 0;

        for (int i = 0; Math.pow(2.0D, i) < subRedesNumeros; i++)
            result = i;
        return result;
    }

    private String convertirIntBinario(int numero)
    {
        String resultado = Integer.toBinaryString(numero);

        for (int i = 8 - resultado.length(); i > 0; i--) {
            resultado = "0" + resultado;
        }
        return resultado;
    }

    private void calcularMascaraSubred(int numeroBits, int[] mascaraSubred)
    {
        int i = 32 - numeroBits; for (int j = 0; j < 4; j++)
    {
        if (i > 8) {
            mascaraSubred[j] = ((int)(Math.pow(2.0D, 8.0D) - 1.0D));
        }
        else
        {
            for (int exponente = 7; i > 0; exponente--)
            {
                mascaraSubred[j] = ((int)(mascaraSubred[j] + Math.pow(2.0D, exponente)));

                i--;
            }
        }
        i -= 8;
    }
    }

    private void calcularHostMax(int numeroBits, int[] redNumeros)
    {
        if (numeroBits < 9)
        {
            redNumeros[3] = ((int)(redNumeros[3] + Math.pow(2.0D, numeroBits) - 2.0D));
        }
        else if (numeroBits < 17)
        {
            redNumeros[3] = ((int)(redNumeros[3] + Math.pow(2.0D, 8.0D) - 2.0D));
            numeroBits -= 8;
            redNumeros[2] = ((int)(redNumeros[2] + Math.pow(2.0D, numeroBits) - 1.0D));
        }
        else if (numeroBits < 25)
        {
            redNumeros[3] = ((int)(redNumeros[3] + Math.pow(2.0D, 8.0D) - 2.0D));
            numeroBits -= 8;
            redNumeros[2] = ((int)(redNumeros[2] + Math.pow(2.0D, 8.0D) - 1.0D));
            numeroBits -= 8;
            redNumeros[1] = ((int)(redNumeros[1] + Math.pow(2.0D, numeroBits) - 1.0D));
        }
    }



    public int[] ordenarArray(int[] array){
        quickSort(array,0,array.length-1);
        return array;
    }


    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }
}
