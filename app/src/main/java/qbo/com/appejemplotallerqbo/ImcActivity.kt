package qbo.com.appejemplotallerqbo

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_imc.*
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    val lstimc = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btncalcularkt.setOnClickListener {
            if(ettallakt.text.toString() == ""){
                ettallakt.error = "Ingrese su talla"
            }else if(etpesokt.text.toString() == ""){
                etpesokt.error = "Ingrese su peso"
            }else{
                var nombre : Double = etpesokt.text.toString().toDouble()
                var nota1 : Double = ettallakt.text.toString().toDouble()
                var nota2 : Double = etnota2.text.toString().toDouble()
                var nota3 : Double = etnota3.text.toString().toDouble()
                var imc : Double
                imc = (nota1 + nota2 + nota3) / 3
                /*var peso : Double = etpesokt.text.toString().toDouble()
                var talla : Double = ettallakt.text.toString().toDouble()
                var tallam : Double
                var imc : Double
                var resultadoIMC : String
                tallam = talla / 100
                imc = peso / (tallam * tallam)
                if(imc <= 18.5) {
                    resultadoIMC = "Por debajo del peso"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcbajo))
                } else if (imc <= 25) {
                    resultadoIMC = "Con peso normal"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcnormal))
                } else if (imc <= 30) {
                    resultadoIMC = "Con sobrepeso"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcsobrepeso))
                } else if (imc <= 35) {
                    resultadoIMC = "Obesidad leve"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcobesidad1))
                } else if (imc <= 39) {
                    resultadoIMC = "Obsesidad media"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcobesidad2))
                } else {
                    resultadoIMC = "Obesidad mórbida"
                    tvresultadokt.setTextColor(ContextCompat.getColor(this, R.color.colorimcobesidad3))
                }
                */
                val df = DecimalFormat("##.00")
                tvresultadokt.text = ("Alumno:" + nombre
                         + " ud. se encuentra: " +
                        df.format(imc))
                lstimc.add("Alumno: " + nombre + " " + df.format(imc))
                val adapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        lstimc)
                lvimckt.adapter = adapter
            }
        }


    }
}
