package sealtyel.example.com.engineeringtoolbox.converter;
/**
 * Created by Buelna on 30/11/2014.
 */
public class Converter {
    public Converter(){}
//funciones de conversion de temperaturas
    public double FtC(double val){return (val-32)/1.8;}
    public double CtF(double val){return (1.8*val)+32;}
    public double KtC(double val){return val-273.14;}
    public double CtK(double val){return val+273.14;}
    public double KtF(double val){return CtF(KtC(val));}
    public double FtK(double val){return CtK(FtC(val));}
//funciones de conversion de longitudes
    public double metroToMilimetro(double val){return val*1000;}
    public double metroToPulgada(double val){return val*39.3700787;}
    public double metroToPie(double val){return val*3.2808399;}
    public double metroToYarda(double val){return val*1.0936133;}
    public double milimetroToPulgada(double val){return val*0.0393701;}
    public double milimetroToPie(double val){return val*0.0032808;}
    public double milimetroToYarda(double val){return val*0.0010936;}
    public double milimetroToMetro(double val){return val*0.001;}
    public double pulgadaToMilimetro(double val){return val*25.4;}
    public double pulgadaToPie(double val){return val*0.08333;}
    public double pulgadaToYarda(double val){return val*0.02777;}
    public double pulgadaToMetro(double val){return val*0.0254;}
    public double pieToMilimetro(double val){return val*304.8;}
    public double pieToPulgada(double val){return val*12;}
    public double pieToYarda(double val){return val*0.333;}
    public double pieToMetro(double val){return val*0.3048;}
    public double yardaToMilimetro(double val){return val*914.4;}
    public double yardaToPulgada(double val){return val*36;}
    public double yardaToPie(double val){return val*3;}
    public double yardaToMetro(double val){return val*0.9144;}
//funciones para la conversion de pesos
    public double kilogramoToGramo(double val){return val*1000;}
    public double kilogramoToLibra(double val){return val*2.20462262;}
    public double kilogramoToOnza(double val){return val*35.2739619;}
    public double gramoToKilogramo(double val){return val/1000;}
    public double gramoToLibra(double val){return val*0.00220462262;}
    public double gramoToOnza(double val){return val*0.0352739619;}
    public double libraToKilogramo(double val){return val/2.20462262;}
    public double libraToGramo(double val){return val/0.00220462262;}
    public double libraToOnza(double val){return val*16;}
    public double onzaToKilogramo(double val){return val/35.2739619;}
    public double onzaToGramo(double val){return val/0.0352739619;}
    public double onzaToLibra(double val){return val/16;}
//funciones para la conversion de velocidades
    public double mpsToKms(double val){return val*0.001;}
    public double mpsToKmh(double val){return val*3.6;}
    public double mpsToMph(double val){return val*2.236936;}
    public double kmsToMps(double val){return val*1000;}
    public double kmsToKmh(double val){return val*3600;}
    public double kmsToMph(double val){return val*2236.936;}
    public double kmhToMps(double val){return val*0.2777778;}
    public double kmhToKms(double val){return val*0.0002778;}
    public double kmhToMph(double val){return val*0.6213711;}
    public double mphToMps(double val){return val*0.4470401;}
    public double mphToKms(double val){return val*0.000447;}
    public double mphToKmh(double val){return val*1.6093442;}
}