package accesoainternet.accesoainternet;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by francis on 16/10/14.
 */
public class AccesoInternet
{
    private Activity actividad;

    public AccesoInternet(Activity actividad)
    {
        this.actividad = actividad;
    }

    public int verificarConexion()
    {
        int conectado = 0;  // Suponemos que no hay conexion
        ConnectivityManager connec = (ConnectivityManager) actividad.getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        // Si hay conexion tanto GPRS como Wifi
        if (redes[0].getState() == NetworkInfo.State.CONNECTED && redes[1].getState() == NetworkInfo.State.CONNECTED)
            conectado = 3;
        else
            // Si hay conexion unicamente de GPRS
            if (redes[0].getState() == NetworkInfo.State.CONNECTED)
                conectado = 1;
            else
                // Si hay conexion unicamente de Wifi
                if (redes[1].getState() == NetworkInfo.State.CONNECTED)
                    conectado = 2;

        return conectado;
    }
}
