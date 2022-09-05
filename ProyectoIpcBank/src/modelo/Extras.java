package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extras {

    public static String fechaHoy() {
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat sdfh = new SimpleDateFormat("HH.mm.ss");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        fechaHoy = ("" + sdf.format(fecha.getTime()) + " " + sdfh.format(fecha.getTime()));
        //fechaHoy = sdf.format(fecha.getTime());
        return fechaHoy;
    }

    public static String fechaReporte() {
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat sdfh = new SimpleDateFormat("HHmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        fechaHoy = ("" + sdf.format(fecha.getTime()) + "" + sdfh.format(fecha.getTime()));
        //fechaHoy = sdf.format(fecha.getTime());
        return fechaHoy;
    }

}
