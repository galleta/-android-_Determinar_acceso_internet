package accesoainternet.accesoainternet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class principal extends Activity
{
    private Button bComprobar = null;
    private TextView tConectadoGPRS = null, tConectadoWifi = null, tEstadoConexion = null;
    private Activity actividadactual = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Obtengo los recursos de la aplicación

        bComprobar = (Button)findViewById(R.id.bComprobar);
        tConectadoGPRS = (TextView)findViewById(R.id.tConectadoGPRS);
        tConectadoWifi = (TextView)findViewById(R.id.tConectadoWifi);
        tEstadoConexion = (TextView)findViewById(R.id.tEstadoConexion);

        bComprobar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            /**
             * Acción onClick del botón bComprobar
             * @param evento onClick
             */
            public void onClick(View evento)
            {
                try
                {
                    AccesoInternet internet = new AccesoInternet(actividadactual);

                    switch(internet.verificarConexion())
                    {
                        case 0:
                            tConectadoGPRS.setText(R.string.textoNoConectado);
                            tConectadoGPRS.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_no_conectado);
                            tConectadoWifi.setText(R.string.textoNoConectado);
                            tConectadoWifi.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_no_conectado);
                            tEstadoConexion.setText(R.string.textoNoConectado);
                            tEstadoConexion.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_no_conectado);
                            break;
                        case 1:
                            tConectadoGPRS.setText(R.string.textoConectado);
                            tConectadoGPRS.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            tConectadoWifi.setText(R.string.textoNoConectado);
                            tConectadoWifi.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_no_conectado);
                            tEstadoConexion.setText(R.string.textoConectadoGPRS);
                            tEstadoConexion.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            break;
                        case 2:
                            tConectadoGPRS.setText(R.string.textoNoConectado);
                            tConectadoGPRS.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_no_conectado);
                            tConectadoWifi.setText(R.string.textoConectado);
                            tConectadoWifi.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            tEstadoConexion.setText(R.string.textoConectadoWifi);
                            tEstadoConexion.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            break;
                        case 3:
                            tConectadoGPRS.setText(R.string.textoConectado);
                            tConectadoGPRS.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            tConectadoWifi.setText(R.string.textoConectado);
                            tConectadoWifi.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            tEstadoConexion.setText(R.string.textoConectadoGPRSWifi);
                            tEstadoConexion.setTextAppearance(actividadactual.getBaseContext(), R.style.estilo_conectado);
                            break;
                    }
                }
                catch (Exception e)
                {
                    Log.i("principal", "Error al pulsar bComprobar: " + e.toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
