package com.example.ceisutb18.pensum20

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pensum.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Pensum : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pensum)

        var matb = arrayOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0','0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')//50
        /*val materias = arrayOf(habilidadesdelpensamiento, seminariosistemas, calculoi)
        val verde = arrayOf(R.drawable.habilidadesdelpensamientoverde,R.drawable.seminariosistemas, R.drawable.calculoi )
        val azul = arrayOf(R.drawable.habilidadesdelpensamientoazul, R.drawable.seminariosistemasazul,R.drawable.calculoiazul)
        val rojo= arrayOf(R.drawable.habilidadesdelpensamientorojo, R.drawable.seminariosistemasrojo, R.drawable.calculoiiirojo)
        val blanco= arrayOf(R.drawable.habilidadesdelpensamientoblanco, R.drawable.seminariosistemas, R.drawable.calculoi)*/


        val objetoIntent: Intent = intent
        var carre = objetoIntent.getStringExtra("carrera")
        txtCarrera.text = "  $carre"


        if (fileList().contains("data10.txt")) try {
            val archivo = InputStreamReader(openFileInput("data10.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            val todo = StringBuilder()
            while (linea != null) {
                todo.append(linea)
                linea = br.readLine()
            }
            br.close()
            archivo.close()
            for (i in 0..49) {
                println(matb[i])
                matb[i] = todo[i]

            }
        } catch (e: IOException) {
        }

        boton1.setOnClickListener {
            try {
                val archivo = OutputStreamWriter(openFileOutput("data10.txt", Activity.MODE_PRIVATE))
                for (i in 0..49)
                    archivo.write( matb[i] + "\n")
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {
            }
            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show()
            finish()
        }

/*for (i in 0..3){
        var a=azul[0]
        var v=verde[0]
        var r=rojo[0]
        var b=blanco[0]
        var button_habilidadesdelpensamiento = matb[0]
        var button_hab = materias[0]
        if (button_habilidadesdelpensamiento == '1') {
            button_hab.setBackgroundResource(a)
        } else if (button_habilidadesdelpensamiento == '2') {
            button_hab.setBackgroundResource(v)
        } else if (button_habilidadesdelpensamiento == '3') {
            button_hab.setBackgroundResource(r)
        }
        button_hab.setOnClickListener {

            if (button_habilidadesdelpensamiento == '3') {
                button_hab.setBackgroundResource(b)
                button_habilidadesdelpensamiento = '0'
            } else if (button_habilidadesdelpensamiento == '0') {
                button_hab.setBackgroundResource(a)
                button_habilidadesdelpensamiento = '1'
            } else if (button_habilidadesdelpensamiento == '1') {
                button_hab.setBackgroundResource(v)
                button_habilidadesdelpensamiento = '2'
            } else if (button_habilidadesdelpensamiento == '2') {
                button_hab.setBackgroundResource(r)
                button_habilidadesdelpensamiento = '3'
            }
            matb[0] = button_habilidadesdelpensamiento
        }
        button_hab.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Habilidades del pensamiento")
            startActivity(intent)
            true
        }
        }*/

        //var button_habilidadesdelpensamiento = matb[0]
        var button_hab = findViewById(R.id.habilidadesdelpensamiento) as Button
        if (matb[0] == '1') {
            button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientoazul)
        } else if (matb[0] == '2') {
            button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientoverde)
        } else if (matb[0] == '3') {
            button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientorojo)
        }
        button_hab.setOnClickListener {
            if (matb[0] == '3') {
                button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientoblanco)
                matb[0] = '0'
            } else if (matb[0] == '0') {
                button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientoazul)
                matb[0] = '1'
            } else if (matb[0] == '1') {
                button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientoverde)
                matb[0] = '2'
            } else if (matb[0] == '2') {
                button_hab.setBackgroundResource(R.drawable.habilidadesdelpensamientorojo)
                matb[0] = '3'
            }
            //matb[0]= button_habilidadesdelpensamiento
        }
        button_hab.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Habilidades del pensamiento")
            startActivity(intent)
            true
        }



        var button_seminariosistemas = matb[1]
        var button_sem = findViewById(R.id.seminariosistemas) as Button
        if (button_seminariosistemas == '1') {
            button_sem.setBackgroundResource(R.drawable.seminariosistemasazul)
        } else if (button_seminariosistemas == '2') {
            button_sem.setBackgroundResource(R.drawable.seminariosistemasverde)
        } else if (button_seminariosistemas == '3') {
            button_sem.setBackgroundResource(R.drawable.seminariosistemasrojo)
        }
        button_sem.setOnClickListener {
            if (button_seminariosistemas == '3') {
                button_sem.setBackgroundResource(R.drawable.seminariosistemas)
                button_seminariosistemas = '0'
            } else if (button_seminariosistemas == '0') {
                button_sem.setBackgroundResource(R.drawable.seminariosistemasazul)
                button_seminariosistemas = '1'
            } else if (button_seminariosistemas == '1') {
                button_sem.setBackgroundResource(R.drawable.seminariosistemasverde)
                button_seminariosistemas = '2'
            } else if (button_seminariosistemas == '2') {
                button_sem.setBackgroundResource(R.drawable.seminariosistemasrojo)
                button_seminariosistemas = '3'
            }
            matb[1] = button_seminariosistemas
        }

        button_sem.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Seminario de sistemas")
            startActivity(intent)
            true
        }

        var button_calculoi = matb[2]
        var button_cali = findViewById(R.id.calculoi) as Button
        if (button_calculoi == '1') {
            button_cali.setBackgroundResource(R.drawable.calculoiazul)
        } else if (button_calculoi == '2') {
            button_cali.setBackgroundResource(R.drawable.calculoiverde)
        } else if (button_calculoi == '3') {
            button_cali.setBackgroundResource(R.drawable.calculoirojo)
        }
        button_cali.setOnClickListener {
            if (button_calculoi == '3') {
                button_cali.setBackgroundResource(R.drawable.calculoi)
                button_calculoi = '0'
            } else if (button_calculoi == '0') {
                button_cali.setBackgroundResource(R.drawable.calculoiazul)
                button_calculoi = '1'
            } else if (button_calculoi == '1') {
                button_cali.setBackgroundResource(R.drawable.calculoiverde)
                button_calculoi = '2'
            } else if (button_calculoi == '2') {
                button_cali.setBackgroundResource(R.drawable.calculoirojo)
                button_calculoi = '3'
            }
            matb[2] = button_calculoi
        }
        button_cali.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", " Calculo I")
            startActivity(intent)
            true
        }

        var button_quimica = matb[3]
        var button_quim = findViewById(R.id.quimica) as Button
        if (button_quimica == '1') {
            button_quim.setBackgroundResource(R.drawable.quimicaazul)
        } else if (button_quimica == '2') {
            button_quim.setBackgroundResource(R.drawable.quimicaverde)
        } else if (button_quimica == '3') {
            button_quim.setBackgroundResource(R.drawable.quimicarojo)
        }
        button_quim.setOnClickListener {
            if (button_quimica == '3') {
                button_quim.setBackgroundResource(R.drawable.quimica)
                button_quimica = '0'
            } else if (button_quimica == '0') {
                button_quim.setBackgroundResource(R.drawable.quimicaazul)
                button_quimica = '1'
            } else if (button_quimica == '1') {
                button_quim.setBackgroundResource(R.drawable.quimicaverde)
                button_quimica = '2'
            } else if (button_quimica == '2') {
                button_quim.setBackgroundResource(R.drawable.quimicarojo)
                button_quimica = '3'
            }
            matb[3] = button_quimica
        }

        button_quim.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Quimica")
            startActivity(intent)
            true
        }

        var algo = matb[4]
        var button_algoritmo = findViewById(R.id.algoritmo) as Button
        if (algo == '1') {
            button_algoritmo.setBackgroundResource(R.drawable.algoritmoazul)
        } else if (algo == '2') {
            button_algoritmo.setBackgroundResource(R.drawable.algoritmoverde)
        } else if (algo == '3') {
            button_algoritmo.setBackgroundResource(R.drawable.algoritmorojo)
        }
        button_algoritmo.setOnClickListener {
            if (algo == '3') {
                button_algoritmo.setBackgroundResource(R.drawable.algoritmo)
                algo = '0'
            } else if (algo == '0') {
                button_algoritmo.setBackgroundResource(R.drawable.algoritmoazul)
                algo = '1'
            } else if (algo == '1') {
                button_algoritmo.setBackgroundResource(R.drawable.algoritmoverde)
                algo = '2'
            } else if (algo == '2') {
                button_algoritmo.setBackgroundResource(R.drawable.algoritmorojo)
                algo = '3'
            }
            matb[4]=algo
        }

        button_algoritmo.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", " Algoritmo")
            startActivity(intent)
            true
        }

        var button_matebasicas = matb[5]
        var button_matebasic = findViewById(R.id.matematicabasicas) as Button
        if (button_matebasicas == '1') {
            button_matebasic.setBackgroundResource(R.drawable.matematicabasicasazul)
        } else if (button_matebasicas == '2') {
            button_matebasic.setBackgroundResource(R.drawable.matematicabasicasverde)
        } else if (button_matebasicas == '3') {
            button_matebasic.setBackgroundResource(R.drawable.matematicabasicasrojo)
        }
        button_matebasic.setOnClickListener {
            if (button_matebasicas == '3') {
                button_matebasic.setBackgroundResource(R.drawable.matematicabasicas)
                button_matebasicas = '0'
            } else if (button_matebasicas == '0') {
                button_matebasic.setBackgroundResource(R.drawable.matematicabasicasazul)
                button_matebasicas = '1'
            } else if (button_matebasicas == '1') {
                button_matebasic.setBackgroundResource(R.drawable.matematicabasicasverde)
                button_matebasicas = '2'
            } else if (button_matebasicas == '2') {
                button_matebasic.setBackgroundResource(R.drawable.matematicabasicasrojo)
                button_matebasicas = '3'
            }
            matb[5] = button_matebasicas
        }
        button_matebasic.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Matematica Basica")
            startActivity(intent)
            true
        }

        var comptexto = matb[6]
        var button_txt = findViewById(R.id.comptexto) as Button
        if (comptexto == '1') {
            button_txt.setBackgroundResource(R.drawable.comptextocientificosazul)
        } else if (comptexto == '2') {
            button_txt.setBackgroundResource(R.drawable.comptextocientificosverde)
        } else if (comptexto == '3') {
            button_txt.setBackgroundResource(R.drawable.comptextocientificosrojo)
        }
        button_txt.setOnClickListener {
            if (comptexto == '3') {
                button_txt.setBackgroundResource(R.drawable.comptextocientificos)
                comptexto = '0'
            } else if (comptexto == '0') {
                button_txt.setBackgroundResource(R.drawable.comptextocientificosazul)
                comptexto = '1'
            } else if (comptexto == '1') {
                button_txt.setBackgroundResource(R.drawable.comptextocientificosverde)
                comptexto = '2'
            } else if (comptexto == '2') {
                button_txt.setBackgroundResource(R.drawable.comptextocientificosrojo)
                comptexto = '3'
            }
            matb[6] = comptexto
        }
        button_txt.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Composicion de Texto Cientificos")
            startActivity(intent)
            true
        }

        var algebra = matb[7]
        var button_alg = findViewById(R.id.algebralineal) as Button
        if (algebra == '1') {
            button_alg.setBackgroundResource(R.drawable.algebralinealazul)
        } else if (algebra == '2') {
            button_alg.setBackgroundResource(R.drawable.algebralinealverde)
        } else if (algebra == '3') {
            button_alg.setBackgroundResource(R.drawable.algebralinealrojo)
        }
        button_alg.setOnClickListener {
            if (algebra == '3') {
                button_alg.setBackgroundResource(R.drawable.algebralineal)
                algebra = '0'
            } else if (algebra == '0') {
                button_alg.setBackgroundResource(R.drawable.algebralinealazul)
                algebra = '1'
            } else if (algebra == '1') {
                button_alg.setBackgroundResource(R.drawable.algebralinealverde)
                algebra = '2'
            } else if (algebra == '2') {
                button_alg.setBackgroundResource(R.drawable.algebralinealrojo)
                algebra = '3'
            }
            matb[7] = comptexto
        }
        button_alg.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Algebra Lineal")
            startActivity(intent)
            true
        }

        var calcii = matb[8]
        var button_calcii = findViewById(R.id.calculoii) as Button
        if (calcii == '1') {
            button_calcii.setBackgroundResource(R.drawable.calculoiiazul)
        } else if (calcii == '2') {
            button_calcii.setBackgroundResource(R.drawable.calculoiiverde)
        } else if (calcii == '3') {
            button_calcii.setBackgroundResource(R.drawable.calculoiirojo)
        }
        button_calcii.setOnClickListener {
            if (calcii == '3') {
                button_calcii.setBackgroundResource(R.drawable.calculoii)
                calcii = '0'
            } else if (calcii == '0') {
                button_calcii.setBackgroundResource(R.drawable.calculoiiazul)
                calcii = '1'
            } else if (calcii == '1') {
                button_calcii.setBackgroundResource(R.drawable.calculoiiverde)
                calcii = '2'
            } else if (calcii == '2') {
                button_calcii.setBackgroundResource(R.drawable.calculoiirojo)
                calcii = '3'
            }
            matb[8] = calcii
        }
        button_calcii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Calculo II")
            startActivity(intent)
            true
        }

        var fisicai = matb[9]
        var button_fisicai = findViewById(R.id.fisicai) as Button
        if (fisicai == '1') {
            button_fisicai.setBackgroundResource(R.drawable.fisicaiazul)
        } else if (fisicai == '2') {
            button_fisicai.setBackgroundResource(R.drawable.fisicaiverde)
        } else if (fisicai == '3') {
            button_fisicai.setBackgroundResource(R.drawable.fisicairojo)
        }
        button_fisicai.setOnClickListener {
            if (fisicai == '3') {
                button_fisicai.setBackgroundResource(R.drawable.fisicai)
                fisicai = '0'
            } else if (fisicai == '0') {
                button_fisicai.setBackgroundResource(R.drawable.fisicaiazul)
                fisicai = '1'
            } else if (fisicai == '1') {
                button_fisicai.setBackgroundResource(R.drawable.fisicaiverde)
                fisicai = '2'
            } else if (fisicai == '2') {
                button_fisicai.setBackgroundResource(R.drawable.fisicairojo)
                fisicai = '3'
            }
            matb[9] = fisicai
        }
        button_fisicai.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Fisica I")
            startActivity(intent)
            true
        }

        var progmi = matb[10]
        var button_progmi = findViewById(R.id.programacion) as Button
        if (progmi == '1') {
            button_progmi.setBackgroundResource(R.drawable.programacionazul)
        } else if (progmi == '2') {
            button_progmi.setBackgroundResource(R.drawable.programacionverde)
        } else if (progmi == '3') {
            button_progmi.setBackgroundResource(R.drawable.programacionrojo)
        }
        button_progmi.setOnClickListener {
            if (progmi == '3') {
                button_progmi.setBackgroundResource(R.drawable.programacion)
                progmi = '0'
            } else if (progmi == '0') {
                button_progmi.setBackgroundResource(R.drawable.programacionazul)
                progmi = '1'
            } else if (progmi == '1') {
                button_progmi.setBackgroundResource(R.drawable.programacionverde)
                progmi = '2'
            } else if (progmi == '2') {
                button_progmi.setBackgroundResource(R.drawable.programacionrojo)
                progmi = '3'
            }
            matb[10] = progmi
        }
        button_progmi.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Programacion I")
            startActivity(intent)
            true
        }

        var exti = matb[11]
        var button_exti = findViewById(R.id.extranjerai) as Button
        if (exti == '1') {
            button_exti.setBackgroundResource(R.drawable.extranjeraiazul)
        } else if (exti == '2') {
            button_exti.setBackgroundResource(R.drawable.extranjeraiverde)
        } else if (exti == '3') {
            button_exti.setBackgroundResource(R.drawable.extranjerairojo)
        }
        button_exti.setOnClickListener {
            if (exti == '3') {
                button_exti.setBackgroundResource(R.drawable.extranjerai)
                exti = '0'
            } else if (exti == '0') {
                button_exti.setBackgroundResource(R.drawable.extranjeraiazul)
                exti = '1'
            } else if (exti == '1') {
                button_exti.setBackgroundResource(R.drawable.extranjeraiverde)
                exti = '2'
            } else if (exti == '2') {
                button_exti.setBackgroundResource(R.drawable.extranjerairojo)
                exti = '3'
            }
            matb[11] = exti
        }
        button_exti.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lengua Extrangera I")
            startActivity(intent)
            true
        }

        var matd = matb[12]
        var button_matd = findViewById(R.id.matematicadiscreta) as Button
        if (matd == '1') {
            button_matd.setBackgroundResource(R.drawable.matediscretaazul)
        } else if (matd == '2') {
            button_matd.setBackgroundResource(R.drawable.matediscretaverde)
        } else if (matd == '3') {
            button_matd.setBackgroundResource(R.drawable.matediscretarojo)
        }
        button_matd.setOnClickListener {
            if (matd == '3') {
                button_matd.setBackgroundResource(R.drawable.matematicadiscreta)
                matd = '0'
            } else if (matd == '0') {
                button_matd.setBackgroundResource(R.drawable.matediscretaazul)
                matd = '1'
            } else if (matd == '1') {
                button_matd.setBackgroundResource(R.drawable.matediscretaverde)
                matd = '2'
            } else if (matd == '2') {
                button_matd.setBackgroundResource(R.drawable.matediscretarojo)
                matd = '3'
            }
            matb[12] = matd
        }
        button_matd.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Matematica Discreta")
            startActivity(intent)
            true
        }

        var caliii = matb[13]
        var button_caliii = findViewById(R.id.calculoiii) as Button
        if (caliii == '1') {
            button_caliii.setBackgroundResource(R.drawable.calculoiiiazul)
        } else if (caliii == '2') {
            button_caliii.setBackgroundResource(R.drawable.calculoiiiverde)
        } else if (caliii == '3') {
            button_caliii.setBackgroundResource(R.drawable.calculoiiirojo)
        }
        button_caliii.setOnClickListener {
            if (caliii == '3') {
                button_caliii.setBackgroundResource(R.drawable.calculoiii)
                caliii = '0'
            } else if (caliii == '0') {
                button_caliii.setBackgroundResource(R.drawable.calculoiiiazul)
                caliii = '1'
            } else if (caliii == '1') {
                button_caliii.setBackgroundResource(R.drawable.calculoiiiverde)
                caliii = '2'
            } else if (caliii == '2') {
                button_caliii.setBackgroundResource(R.drawable.calculoiiirojo)
                caliii = '3'
            }
            matb[13] = caliii
        }
        button_caliii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Calculo III")
            startActivity(intent)
            true
        }

        var fisicii = matb[14]
        var button_fisicii = findViewById(R.id.fisicaii) as Button
        if (fisicii == '1') {
            button_fisicii.setBackgroundResource(R.drawable.fisicaiiazul)
        } else if (fisicii == '2') {
            button_fisicii.setBackgroundResource(R.drawable.fisicaiiverde)
        } else if (fisicii == '3') {
            button_fisicii.setBackgroundResource(R.drawable.fisicaiirojo)
        }
        button_fisicii.setOnClickListener {
            if (fisicii == '3') {
                button_fisicii.setBackgroundResource(R.drawable.fisicaii)
                fisicii = '0'
            } else if (fisicii == '0') {
                button_fisicii.setBackgroundResource(R.drawable.fisicaiiazul)
                fisicii = '1'
            } else if (fisicii == '1') {
                button_fisicii.setBackgroundResource(R.drawable.fisicaiiverde)
                fisicii = '2'
            } else if (fisicii == '2') {
                button_fisicii.setBackgroundResource(R.drawable.fisicaiirojo)
                fisicii = '3'
            }
            matb[14] = fisicii
        }
        button_fisicii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Fisica II")
            startActivity(intent)
            true
        }

        var progmii = matb[15]
        var button_progmii = findViewById(R.id.programacionii) as Button
        if (progmii == '1') {
            button_progmii.setBackgroundResource(R.drawable.programacioniiazul)
        } else if (progmii == '2') {
            button_progmii.setBackgroundResource(R.drawable.programacioniiverde)
        } else if (progmii == '3') {
            button_progmii.setBackgroundResource(R.drawable.programacioniirojo)
        }
        button_progmii.setOnClickListener {
            if (progmii == '3') {
                button_progmii.setBackgroundResource(R.drawable.programacionii)
                progmii = '0'
            } else if (progmii == '0') {
                button_progmii.setBackgroundResource(R.drawable.programacioniiazul)
                progmii = '1'
            } else if (progmii == '1') {
                button_progmii.setBackgroundResource(R.drawable.programacioniiverde)
                progmii = '2'
            } else if (progmii == '2') {
                button_progmii.setBackgroundResource(R.drawable.programacioniirojo)
                progmii = '3'
            }
            matb[15] = progmii
        }
        button_progmii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Programacion II")
            startActivity(intent)
            true
        }



        var hum = matb[16]
        var button_hum = findViewById(R.id.humanidades) as Button
        if (hum == '1') {
            button_hum.setBackgroundResource(R.drawable.humanidadesazul)
        } else if (hum == '2') {
            button_hum.setBackgroundResource(R.drawable.humanidadesverde)
        } else if (hum == '3') {
            button_hum.setBackgroundResource(R.drawable.humanidadesrojo)
        }
        button_hum.setOnClickListener {
            if (hum == '3') {
                button_hum.setBackgroundResource(R.drawable.humanidades)
                hum = '0'
            } else if (hum == '0') {
                button_hum.setBackgroundResource(R.drawable.humanidadesazul)
                hum = '1'
            } else if (hum == '1') {
                button_hum.setBackgroundResource(R.drawable.humanidadesverde)
                hum = '2'
            } else if (hum == '2') {
                button_hum.setBackgroundResource(R.drawable.humanidadesrojo)
                hum = '3'
            }
            matb[16] = hum
        }
        button_hum.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva de Humanidades")
            startActivity(intent)
            true
        }




        var extii = matb[17]
        var button_extii = findViewById(R.id.extranjeraii) as Button
        if (extii == '1') {
            button_extii.setBackgroundResource(R.drawable.extranjeraiiazul)
        } else if (extii == '2') {
            button_extii.setBackgroundResource(R.drawable.extranjeraiiverde)
        } else if (extii == '3') {
            button_extii.setBackgroundResource(R.drawable.extranjeraiirojo)
        }
        button_extii.setOnClickListener {
            if (extii == '3') {
                button_extii.setBackgroundResource(R.drawable.extranjeraii)
                extii = '0'
            } else if (extii == '0') {
                button_extii.setBackgroundResource(R.drawable.extranjeraiiazul)
                extii = '1'
            } else if (extii == '1') {
                button_extii.setBackgroundResource(R.drawable.extranjeraiiverde)
                extii = '2'
            } else if (extii == '2') {
                button_extii.setBackgroundResource(R.drawable.extranjeraiirojo)
                extii = '3'
            }
            matb[17] = extii
        }
        button_extii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lengua Extrangera II")
            startActivity(intent)
            true
        }

        var esta = matb[18]
        var button_esta = findViewById(R.id.estadistica) as Button
        if (esta == '1') {
            button_esta.setBackgroundResource(R.drawable.estadisticaazul)
        } else if (esta == '2') {
            button_esta.setBackgroundResource(R.drawable.estadisticaverde)
        } else if (esta == '3') {
            button_esta.setBackgroundResource(R.drawable.estadisticarojo)
        }
        button_esta.setOnClickListener {
            if (esta == '3') {
                button_esta.setBackgroundResource(R.drawable.estadistica)
                esta = '0'
            } else if (esta == '0') {
                button_esta.setBackgroundResource(R.drawable.estadisticaazul)
                esta = '1'
            } else if (esta == '1') {
                button_esta.setBackgroundResource(R.drawable.estadisticaverde)
                esta = '2'
            } else if (esta == '2') {
                button_esta.setBackgroundResource(R.drawable.estadisticarojo)
                esta = '3'
            }
            matb[18] = esta
        }
        button_esta.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Estadistica I")
            startActivity(intent)
            true
        }

        var metodosnum = matb[19]
        var button_metnum = findViewById(R.id.metodosnumericos) as Button
        if (metodosnum == '1') {
            button_metnum.setBackgroundResource(R.drawable.metodosnumericosazul)
        } else if (metodosnum == '2') {
            button_metnum.setBackgroundResource(R.drawable.metodosnumericosverde)
        } else if (metodosnum == '3') {
            button_metnum.setBackgroundResource(R.drawable.metodosnumericosrojo)
        }
        button_metnum.setOnClickListener {
            if (metodosnum == '3') {
                button_metnum.setBackgroundResource(R.drawable.metodosnumericos)
                metodosnum = '0'
            } else if (metodosnum == '0') {
                button_metnum.setBackgroundResource(R.drawable.metodosnumericosazul)
                metodosnum = '1'
            } else if (metodosnum == '1') {
                button_metnum.setBackgroundResource(R.drawable.metodosnumericosverde)
                metodosnum = '2'
            } else if (metodosnum == '2') {
                button_metnum.setBackgroundResource(R.drawable.metodosnumericosrojo)
                metodosnum = '3'
            }
            matb[19] = metodosnum
        }
        button_metnum.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Metodos")
            startActivity(intent)
            true
        }

        var ecu = matb[20]
        var button_ecu = findViewById(R.id.ecuaciones) as Button
        if (ecu == '1') {
            button_ecu.setBackgroundResource(R.drawable.ecuacionesazul)
        } else if (ecu == '2') {
            button_ecu.setBackgroundResource(R.drawable.ecuacionesverde)
        } else if (ecu == '3') {
            button_ecu.setBackgroundResource(R.drawable.ecuacionesrojo)
        }
        button_ecu.setOnClickListener {
            if (ecu == '3') {
                button_ecu.setBackgroundResource(R.drawable.ecuaciones)
                ecu = '0'
            } else if (ecu == '0') {
                button_ecu.setBackgroundResource(R.drawable.ecuacionesazul)
                ecu = '1'
            } else if (ecu == '1') {
                button_ecu.setBackgroundResource(R.drawable.ecuacionesverde)
                ecu = '2'
            } else if (ecu == '2') {
                button_ecu.setBackgroundResource(R.drawable.ecuacionesrojo)
                ecu = '3'
            }
            matb[20] = ecu
        }
        button_ecu.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Ecuaciones Diferenciales y en Diferencias")
            startActivity(intent)
            true
        }

        var elec4 = matb[21]
        var button_elec4 = findViewById(R.id.electiva) as Button
        if (elec4 == '1') {
            button_elec4.setBackgroundResource(R.drawable.electivaazul)
        } else if (elec4 == '2') {
            button_elec4.setBackgroundResource(R.drawable.electivaverde)
        } else if (elec4 == '3') {
            button_elec4.setBackgroundResource(R.drawable.electivarojo)
        }
        button_elec4.setOnClickListener {
            if (elec4 == '3') {
                button_elec4.setBackgroundResource(R.drawable.electiva)
                elec4 = '0'
            } else if (elec4 == '0') {
                button_elec4.setBackgroundResource(R.drawable.electivaazul)
                elec4 = '1'
            } else if (elec4 == '1') {
                button_elec4.setBackgroundResource(R.drawable.electivaverde)
                elec4 = '2'
            } else if (elec4 == '2') {
                button_elec4.setBackgroundResource(R.drawable.electivarojo)
                elec4 = '3'
            }
            matb[21] = elec4
        }
        button_elec4.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva de Ingenieria")
            startActivity(intent)
            true
        }

        var estr = matb[22]
        var button_estr = findViewById(R.id.estructuradatos) as Button
        if (estr == '1') {
            button_estr.setBackgroundResource(R.drawable.estructuradatosazul)
        } else if (estr == '2') {
            button_estr.setBackgroundResource(R.drawable.estructuradatosverde)
        } else if (estr == '3') {
            button_estr.setBackgroundResource(R.drawable.estructuradatosrojo)
        }
        button_estr.setOnClickListener {
            if (estr == '3') {
                button_estr.setBackgroundResource(R.drawable.estructuradatos)
                estr = '0'
            } else if (estr == '0') {
                button_estr.setBackgroundResource(R.drawable.estructuradatosazul)
                estr = '1'
            } else if (estr == '1') {
                button_estr.setBackgroundResource(R.drawable.estructuradatosverde)
                estr = '2'
            } else if (estr == '2') {
                button_estr.setBackgroundResource(R.drawable.estructuradatosrojo)
                estr = '3'
            }
            matb[22] = estr
        }
        button_estr.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Estructura de Datos")
            startActivity(intent)
            true
        }

        var button_extiii = findViewById(R.id.extranjeraiii) as Button
        if (matb[23] == '1') {
            button_extiii.setBackgroundResource(R.drawable.extranjeraiiiazul)
        } else if (matb[23] == '2') {
            button_extiii.setBackgroundResource(R.drawable.extranjeraiiiverde)
        } else if (matb[23] == '3') {
            button_extiii.setBackgroundResource(R.drawable.extranjeraiiirojo)
        }
        button_extiii.setOnClickListener {
            if (matb[23] == '3') {
                button_extiii.setBackgroundResource(R.drawable.extranjeraiii)
                matb[23] = '0'
            } else if (matb[23] == '0') {
                button_extiii.setBackgroundResource(R.drawable.extranjeraiiiazul)
                matb[23] = '1'
            } else if (matb[23] == '1') {
                button_extiii.setBackgroundResource(R.drawable.extranjeraiiiverde)
                matb[23] = '2'
            } else if (matb[23] == '2') {
                button_extiii.setBackgroundResource(R.drawable.extranjeraiiirojo)
                matb[23] = '3'
            }
        }
        button_extiii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lengua Extrangera III")
            startActivity(intent)
            true
        }

        var button_entr = findViewById(R.id.entornoeconomico) as Button
        if (matb[24] == '1') {
            button_entr.setBackgroundResource(R.drawable.entornoeconomicoazul)
        } else if (matb[24] == '2') {
            button_entr.setBackgroundResource(R.drawable.entornoeconomicoverde)
        } else if (matb[24] == '3') {
            button_entr.setBackgroundResource(R.drawable.entornoeconomicorojo)
        }
        button_entr.setOnClickListener {
            if (matb[24] == '3') {
                button_entr.setBackgroundResource(R.drawable.entornoeconomico)
                matb[24] = '0'
            } else if (matb[24] == '0') {
                button_entr.setBackgroundResource(R.drawable.entornoeconomicoazul)
                matb[24] = '1'
            } else if (matb[24] == '1') {
                button_entr.setBackgroundResource(R.drawable.entornoeconomicoverde)
                matb[24] = '2'
            } else if (matb[24] == '2') {
                button_entr.setBackgroundResource(R.drawable.entornoeconomicorojo)
                matb[24] = '3'
            }
        }
        button_entr.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Entorno Economico")
            startActivity(intent)
            true
        }

        var button_teorcomp = findViewById(R.id.teoriadelacomp) as Button
        if (matb[25] == '1') {
            button_teorcomp.setBackgroundResource(R.drawable.teoriadelacompazul)
        } else if (matb[25] == '2') {
            button_teorcomp.setBackgroundResource(R.drawable.teoriadelacompverde)
        } else if (matb[25] == '3') {
            button_teorcomp.setBackgroundResource(R.drawable.teoriadelacomprojo)
        }
        button_teorcomp.setOnClickListener {
            if (matb[25] == '3') {
                button_teorcomp.setBackgroundResource(R.drawable.teoriadelacomp)
                matb[25] = '0'
            } else if (matb[25] == '0') {
                button_teorcomp.setBackgroundResource(R.drawable.teoriadelacompazul)
                matb[25] = '1'
            } else if (matb[25] == '1') {
                button_teorcomp.setBackgroundResource(R.drawable.teoriadelacompverde)
                matb[25] = '2'
            } else if (matb[25] == '2') {
                button_teorcomp.setBackgroundResource(R.drawable.teoriadelacomprojo)
                matb[25] = '3'
            }
        }
        button_teorcomp.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Teoria de la Computacion")
            startActivity(intent)
            true
        }

        var button_ensambl = findViewById(R.id.ensamblador) as Button
        if (matb[26] == '1') {
            button_ensambl.setBackgroundResource(R.drawable.ensambladorazul)
        } else if (matb[26] == '2') {
            button_ensambl.setBackgroundResource(R.drawable.ensambladorverde)
        } else if (matb[26] == '3') {
            button_ensambl.setBackgroundResource(R.drawable.ensambladorrojo)
        }
        button_ensambl.setOnClickListener {
            if (matb[26] == '3') {
                button_ensambl.setBackgroundResource(R.drawable.ensamblador)
                matb[26] = '0'
            } else if (matb[26] == '0') {
                button_ensambl.setBackgroundResource(R.drawable.ensambladorazul)
                matb[26] = '1'
            } else if (matb[26] == '1') {
                button_ensambl.setBackgroundResource(R.drawable.ensambladorverde)
                matb[26] = '2'
            } else if (matb[26] == '2') {
                button_ensambl.setBackgroundResource(R.drawable.ensambladorrojo)
                matb[26] = '3'
            }
        }
        button_ensambl.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Aquitectura y Ensamblador")
            startActivity(intent)
            true
        }

        var button_base = findViewById(R.id.basededatos) as Button
        if (matb[27] == '1') {
            button_base.setBackgroundResource(R.drawable.basededatosazul)
        } else if (matb[27] == '2') {
            button_base.setBackgroundResource(R.drawable.basededatosverde)
        } else if (matb[27] == '3') {
            button_base.setBackgroundResource(R.drawable.basededatosrojo)
        }
        button_base.setOnClickListener {
            if (matb[27] == '3') {
                button_base.setBackgroundResource(R.drawable.basededatos)
                matb[27] = '0'
            } else if (matb[27] == '0') {
                button_base.setBackgroundResource(R.drawable.basededatosazul)
                matb[27] = '1'
            } else if (matb[27] == '1') {
                button_base.setBackgroundResource(R.drawable.basededatosverde)
                matb[27] = '2'
            } else if (matb[27] == '2') {
                button_base.setBackgroundResource(R.drawable.basededatosrojo)
                matb[27] = '3'
            }
        }
        button_base.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Base de Datos")
            startActivity(intent)
            true
        }

        var button_fisciii = findViewById(R.id.fisicaiii) as Button
        if (matb[28] == '1') {
            button_fisciii.setBackgroundResource(R.drawable.fisicaiiiazul)
        } else if (matb[28] == '2') {
            button_fisciii.setBackgroundResource(R.drawable.fisicaiiiverde)
        } else if (matb[28] == '3') {
            button_fisciii.setBackgroundResource(R.drawable.fisicaiiirojo)
        }
        button_fisciii.setOnClickListener {
            if (matb[28] == '3') {
                button_fisciii.setBackgroundResource(R.drawable.fisicaiii)
                matb[28] = '0'
            } else if (matb[28] == '0') {
                button_fisciii.setBackgroundResource(R.drawable.fisicaiiiazul)
                matb[28] = '1'
            } else if (matb[28] == '1') {
                button_fisciii.setBackgroundResource(R.drawable.fisicaiiiverde)
                matb[28] = '2'
            } else if (matb[28] == '2') {
                button_fisciii.setBackgroundResource(R.drawable.fisicaiiirojo)
                matb[28] = '3'
            }
        }
        button_fisciii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Fisica III")
            startActivity(intent)
            true
        }

        var button_extiv = findViewById(R.id.extranjeraiv) as Button
        if (matb[29] == '1') {
            button_extiv.setBackgroundResource(R.drawable.extranjeraivazul)
        } else if (matb[29] == '2') {
            button_extiv.setBackgroundResource(R.drawable.extranjeraivverde)
        } else if (matb[29] == '3') {
            button_extiv.setBackgroundResource(R.drawable.extranjeraivrojo)
        }
        button_extiv.setOnClickListener {
            if (matb[29] == '3') {
                button_extiv.setBackgroundResource(R.drawable.extranjeraiv)
                matb[29] = '0'
            } else if (matb[29] == '0') {
                button_extiv.setBackgroundResource(R.drawable.extranjeraivazul)
                matb[29] = '1'
            } else if (matb[29] == '1') {
                button_extiv.setBackgroundResource(R.drawable.extranjeraivverde)
                matb[29] = '2'
            } else if (matb[29] == '2') {
                button_extiv.setBackgroundResource(R.drawable.extranjeraivrojo)
                matb[29] = '3'
            }
        }
        button_extiv.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lengua Extrangera IV")
            startActivity(intent)
            true
        }

        var button_emp = findViewById(R.id.electivaempresarial) as Button
        if (matb[30] == '1') {
            button_emp.setBackgroundResource(R.drawable.electivaempresarialazul)
        } else if (matb[30] == '2') {
            button_emp.setBackgroundResource(R.drawable.electivaempresarialverde)
        } else if (matb[30] == '3') {
            button_emp.setBackgroundResource(R.drawable.electivaempresarialrojo)
        }
        button_emp.setOnClickListener {
            if (matb[30] == '3') {
                button_emp.setBackgroundResource(R.drawable.electivaempresarial)
                matb[30] = '0'
            } else if (matb[30] == '0') {
                button_emp.setBackgroundResource(R.drawable.electivaempresarialazul)
                matb[30] = '1'
            } else if (matb[30] == '1') {
                button_emp.setBackgroundResource(R.drawable.electivaempresarialverde)
                matb[30] = '2'
            } else if (matb[30] == '2') {
                button_emp.setBackgroundResource(R.drawable.electivaempresarialrojo)
                matb[30] = '3'
            }
        }
        button_emp.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva Empresarial")
            startActivity(intent)
            true
        }

        var button_lengprog = findViewById(R.id.lengprog) as Button
        if (matb[31] == '1') {
            button_lengprog.setBackgroundResource(R.drawable.lengprogramacionazul)
        } else if (matb[31] == '2') {
            button_lengprog.setBackgroundResource(R.drawable.lengprogramacionverde)
        } else if (matb[31] == '3') {
            button_lengprog.setBackgroundResource(R.drawable.lengprogramacionrojo)
        }
        button_lengprog.setOnClickListener {
            if (matb[31] == '3') {
                button_lengprog.setBackgroundResource(R.drawable.lengprogramacion)
                matb[31] = '0'
            } else if (matb[31] == '0') {
                button_lengprog.setBackgroundResource(R.drawable.lengprogramacionazul)
                matb[31] = '1'
            } else if (matb[31] == '1') {
                button_lengprog.setBackgroundResource(R.drawable.lengprogramacionverde)
                matb[31] = '2'
            } else if (matb[31] == '2') {
                button_lengprog.setBackgroundResource(R.drawable.lengprogramacionrojo)
                matb[31] = '3'
            }
        }
        button_lengprog.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lenguaje De Programacion")
            startActivity(intent)
            true
        }

        var button_modcuant = findViewById(R.id.modcuanti) as Button
        if (matb[32] == '1') {
            button_modcuant.setBackgroundResource(R.drawable.modcuantitativosazul)
        } else if (matb[32] == '2') {
            button_modcuant.setBackgroundResource(R.drawable.modcuantitativosverde)
        } else if (matb[32] == '3') {
            button_modcuant.setBackgroundResource(R.drawable.modcuantitativosrojo)
        }
        button_modcuant.setOnClickListener {
            if (matb[32] == '3') {
                button_modcuant.setBackgroundResource(R.drawable.modcuantitativos)
                matb[32] = '0'
            } else if (matb[32] == '0') {
                button_modcuant.setBackgroundResource(R.drawable.modcuantitativosazul)
                matb[32] = '1'
            } else if (matb[32] == '1') {
                button_modcuant.setBackgroundResource(R.drawable.modcuantitativosverde)
                matb[32] = '2'
            } else if (matb[32] == '2') {
                button_modcuant.setBackgroundResource(R.drawable.modcuantitativosrojo)
                matb[32] = '3'
            }
        }
        button_modcuant.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Modelo Cuantitativos")
            startActivity(intent)
            true
        }

        var button_red = findViewById(R.id.redes) as Button
        if (matb[33] == '1') {
            button_red.setBackgroundResource(R.drawable.compredesdecompazul)
        } else if (matb[33] == '2') {
            button_red.setBackgroundResource(R.drawable.compredesdecompverde)
        } else if (matb[33] == '3') {
            button_red.setBackgroundResource(R.drawable.compredesdecomprojo)
        }
        button_red.setOnClickListener {
            if (matb[33] == '3') {
                button_red.setBackgroundResource(R.drawable.compredesdecomp)
                matb[33] = '0'
            } else if (matb[33] == '0') {
                button_red.setBackgroundResource(R.drawable.compredesdecompazul)
                matb[33] = '1'
            } else if (matb[33] == '1') {
                button_red.setBackgroundResource(R.drawable.compredesdecompverde)
                matb[33] = '2'
            } else if (matb[33] == '2') {
                button_red.setBackgroundResource(R.drawable.compredesdecomprojo)
                matb[33] = '3'
            }
        }
        button_red.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Comunicacion y Redes De Computacion")
            startActivity(intent)
            true
        }

        var button_ingsoftw = findViewById(R.id.ingsoftware) as Button
        if (matb[34] == '1') {
            button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwareazul)
        } else if (matb[34] == '2') {
            button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwareverde)
        } else if (matb[34] == '3') {
            button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwarerojo)
        }
        button_ingsoftw.setOnClickListener {
            if (matb[34] == '3') {
                button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftware)
                matb[34] = '0'
            } else if (matb[34] == '0') {
                button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwareazul)
                matb[34] = '1'
            } else if (matb[34] == '1') {
                button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwareverde)
                matb[34] = '2'
            } else if (matb[34] == '2') {
                button_ingsoftw.setBackgroundResource(R.drawable.ingdesoftwarerojo)
                matb[34] = '3'
            }
        }
        button_ingsoftw.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Ingenieria De Software I")
            startActivity(intent)
            true
        }

        var button_extrav = findViewById(R.id.extranjerav) as Button
        if (matb[35] == '1') {
            button_extrav.setBackgroundResource(R.drawable.extrangeravazul)
        } else if (matb[35] == '2') {
            button_extrav.setBackgroundResource(R.drawable.extrangeravverde)
        } else if (matb[35] == '3') {
            button_extrav.setBackgroundResource(R.drawable.extrangeravrojo)
        }
        button_extrav.setOnClickListener {
            if (matb[35] == '3') {
                button_extrav.setBackgroundResource(R.drawable.extrangerav)
                matb[35] = '0'
            } else if (matb[35] == '0') {
                button_extrav.setBackgroundResource(R.drawable.extrangeravazul)
                matb[35] = '1'
            } else if (matb[35] == '1') {
                button_extrav.setBackgroundResource(R.drawable.extrangeravverde)
                matb[35] = '2'
            } else if (matb[35] == '2') {
                button_extrav.setBackgroundResource(R.drawable.extrangeravrojo)
                matb[35] = '3'
            }
        }
        button_extrav.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Lengua Extrangera V")
            startActivity(intent)
            true
        }

        var button_gest = findViewById(R.id.gestiondeproyecto) as Button
        if (matb[36] == '1') {
            button_gest.setBackgroundResource(R.drawable.gestiondeproyectoazul)
        } else if (matb[36] == '2') {
            button_gest.setBackgroundResource(R.drawable.gestiondeproyectoverde)
        } else if (matb[36] == '3') {
            button_gest.setBackgroundResource(R.drawable.gestiondeproyectorojo)
        }
        button_gest.setOnClickListener {
            if (matb[36] == '3') {
                button_gest.setBackgroundResource(R.drawable.gestiondeproyecto)
                matb[36] = '0'
            } else if (matb[36] == '0') {
                button_gest.setBackgroundResource(R.drawable.gestiondeproyectoazul)
                matb[36] = '1'
            } else if (matb[36] == '1') {
                button_gest.setBackgroundResource(R.drawable.gestiondeproyectoverde)
                matb[36] = '2'
            } else if (matb[36] == '2') {
                button_gest.setBackgroundResource(R.drawable.gestiondeproyectorojo)
                matb[36] = '3'
            }
        }
        button_gest.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Gestion de Proyecto")
            startActivity(intent)
            true
        }

        var button_hum7 = findViewById(R.id.humanidades7) as Button
        if (matb[37] == '1') {
            button_hum7.setBackgroundResource(R.drawable.humanidades7azul)
        } else if (matb[37] == '2') {
            button_hum7.setBackgroundResource(R.drawable.humanidades7verde)
        } else if (matb[37] == '3') {
            button_hum7.setBackgroundResource(R.drawable.humanidades7rojo)
        }
        button_hum7.setOnClickListener {
            if (matb[37] == '3') {
                button_hum7.setBackgroundResource(R.drawable.humanidades7)
                matb[37] = '0'
            } else if (matb[37] == '0') {
                button_hum7.setBackgroundResource(R.drawable.humanidades7azul)
                matb[37] = '1'
            } else if (matb[37] == '1') {
                button_hum7.setBackgroundResource(R.drawable.humanidades7verde)
                matb[37] = '2'
            } else if (matb[37] == '2') {
                button_hum7.setBackgroundResource(R.drawable.humanidades7rojo)
                matb[37] = '3'
            }
        }
        button_hum7.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva de Humanidades")
            startActivity(intent)
            true
        }

        var button_stsdinm = findViewById(R.id.sistemdinamico) as Button
        if (matb[38] == '1') {
            button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosazul)
        } else if (matb[38] == '2') {
            button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosverde)
        } else if (matb[38] == '3') {
            button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosrojo)
        }
        button_stsdinm.setOnClickListener {
            if (matb[38] == '3') {
                button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicos)
                matb[38] = '0'
            } else if (matb[38] == '0') {
                button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosazul)
                matb[38] = '1'
            } else if (matb[38] == '1') {
                button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosverde)
                matb[38] = '2'
            } else if (matb[38] == '2') {
                button_stsdinm.setBackgroundResource(R.drawable.sistemasdinamicosrojo)
                matb[38] = '3'
            }
        }
        button_stsdinm.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Sistemas Dinamicos y Simulacion")
            startActivity(intent)
            true
        }

        var button_sistopert = findViewById(R.id.sistmoperativo) as Button
        if (matb[39] == '1') {
            button_sistopert.setBackgroundResource(R.drawable.sisoperativosazul)
        } else if (matb[39] == '2') {
            button_sistopert.setBackgroundResource(R.drawable.sisoperativosverde)
        } else if (matb[39] == '3') {
            button_sistopert.setBackgroundResource(R.drawable.sisoperativosrojo)
        }
        button_sistopert.setOnClickListener {
            if (matb[39] == '3') {
                button_sistopert.setBackgroundResource(R.drawable.sisoperativos)
                matb[39] = '0'
            } else if (matb[39] == '0') {
                button_sistopert.setBackgroundResource(R.drawable.sisoperativosazul)
                matb[39] = '1'
            } else if (matb[39] == '1') {
                button_sistopert.setBackgroundResource(R.drawable.sisoperativosverde)
                matb[39] = '2'
            } else if (matb[39] == '2') {
                button_sistopert.setBackgroundResource(R.drawable.sisoperativosrojo)
                matb[39] = '3'
            }
        }
        button_sistopert.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Sistemas Operativos")
            startActivity(intent)
            true
        }

        var button_ingsoftii = findViewById(R.id.ingsofwareii) as Button
        if (matb[40] == '1') {
            button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiiazul)
        } else if (matb[40] == '2') {
            button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiiverde)
        } else if (matb[40] == '3') {
            button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiirojo)
        }
        button_ingsoftii.setOnClickListener {
            if (matb[40] == '3') {
                button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareii)
                matb[40] = '0'
            } else if (matb[40] == '0') {
                button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiiazul)
                matb[40] = '1'
            } else if (matb[40] == '1') {
                button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiiverde)
                matb[40] = '2'
            } else if (matb[40] == '2') {
                button_ingsoftii.setBackgroundResource(R.drawable.ingsofwareiirojo)
                matb[40] = '3'
            }
        }
        button_ingsoftii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Ingenieria De Software II")
            startActivity(intent)
            true
        }

        var button_poolt = findViewById(R.id.politica) as Button
        if (matb[41] == '1') {
            button_poolt.setBackgroundResource(R.drawable.politicaazul)
        } else if (matb[41] == '2') {
            button_poolt.setBackgroundResource(R.drawable.politicaverde)
        } else if (matb[41] == '3') {
            button_poolt.setBackgroundResource(R.drawable.politicarojo)
        }
        button_poolt.setOnClickListener {
            if (matb[41] == '3') {
                button_poolt.setBackgroundResource(R.drawable.politica)
                matb[41] = '0'
            } else if (matb[41] == '0') {
                button_poolt.setBackgroundResource(R.drawable.politicaazul)
                matb[41] = '1'
            } else if (matb[41] == '1') {
                button_poolt.setBackgroundResource(R.drawable.politicaverde)
                matb[41] = '2'
            } else if (matb[41] == '2') {
                button_poolt.setBackgroundResource(R.drawable.politicarojo)
                matb[41] = '3'
            }
        }
        button_poolt.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Constitucion Politica y Civil")
            startActivity(intent)
            true
        }

        var button_elect8 = findViewById(R.id.electv8) as Button
        if (matb[42] == '1') {
            button_elect8.setBackgroundResource(R.drawable.elecing8azul)
        } else if (matb[42] == '2') {
            button_elect8.setBackgroundResource(R.drawable.elecing8verde)
        } else if (matb[42] == '3') {
            button_elect8.setBackgroundResource(R.drawable.elecing8rojo)
        }
        button_elect8.setOnClickListener {
            if (matb[42] == '3') {
                button_elect8.setBackgroundResource(R.drawable.elecing8)
                matb[42] = '0'
            } else if (matb[42] == '0') {
                button_elect8.setBackgroundResource(R.drawable.elecing8azul)
                matb[42] = '1'
            } else if (matb[42] == '1') {
                button_elect8.setBackgroundResource(R.drawable.elecing8verde)
                matb[42] = '2'
            } else if (matb[42] == '2') {
                button_elect8.setBackgroundResource(R.drawable.elecing8rojo)
                matb[42] = '3'
            }
        }
        button_elect8.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva De Ingenieria")
            startActivity(intent)
            true
        }

        var button_hum8 = findViewById(R.id.humanidades8) as Button
        if (matb[43] == '1') {
            button_hum8.setBackgroundResource(R.drawable.humanidades8azul)
        } else if (matb[43] == '2') {
            button_hum8.setBackgroundResource(R.drawable.humanidades8verde)
        } else if (matb[43] == '3') {
            button_hum8.setBackgroundResource(R.drawable.humanidades8rojo)
        }
        button_hum8.setOnClickListener {
            if (matb[43] == '3') {
                button_hum8.setBackgroundResource(R.drawable.humanidades8)
                matb[43] = '0'
            } else if (matb[43] == '0') {
                button_hum8.setBackgroundResource(R.drawable.humanidades8azul)
                matb[43] = '1'
            } else if (matb[43] == '1') {
                button_hum8.setBackgroundResource(R.drawable.humanidades8verde)
                matb[43] = '2'
            } else if (matb[43] == '2') {
                button_hum8.setBackgroundResource(R.drawable.humanidades8rojo)
                matb[43] = '3'
            }
        }
        button_hum8.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva De Humanidades")
            startActivity(intent)
            true
        }

        var button_inte = findViewById(R.id.inteartificial) as Button
        if (matb[44] == '1') {
            button_inte.setBackgroundResource(R.drawable.inteartificialazul)
        } else if (matb[44] == '2') {
            button_inte.setBackgroundResource(R.drawable.inteartificialverde)
        } else if (matb[44] == '3') {
            button_inte.setBackgroundResource(R.drawable.inteartificialrojo)
        }
        button_inte.setOnClickListener {
            if (matb[44] == '3') {
                button_inte.setBackgroundResource(R.drawable.inteartificial)
                matb[44] = '0'
            } else if (matb[44] == '0') {
                button_inte.setBackgroundResource(R.drawable.inteartificialazul)
                matb[44] = '1'
            } else if (matb[44] == '1') {
                button_inte.setBackgroundResource(R.drawable.inteartificialverde)
                matb[44] = '2'
            } else if (matb[44] == '2') {
                button_inte.setBackgroundResource(R.drawable.inteartificialrojo)
                matb[44] = '3'
            }
        }
        button_inte.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Inteligencia Artificial")
            startActivity(intent)
            true
        }

        var button_elect8ii = findViewById(R.id.elecing8ii) as Button
        if (matb[45] == '1') {
            button_elect8ii.setBackgroundResource(R.drawable.elecing8iiazul)
        } else if (matb[45] == '2') {
            button_elect8ii.setBackgroundResource(R.drawable.elecing8iiverde)
        } else if (matb[45] == '3') {
            button_elect8ii.setBackgroundResource(R.drawable.elecing8iirojo)
        }
        button_elect8ii.setOnClickListener {
            if (matb[45] == '3') {
                button_elect8ii.setBackgroundResource(R.drawable.elecing8ii)
                matb[45] = '0'
            } else if (matb[45] == '0') {
                button_elect8ii.setBackgroundResource(R.drawable.elecing8iiazul)
                matb[45] = '1'
            } else if (matb[45] == '1') {
                button_elect8ii.setBackgroundResource(R.drawable.elecing8iiverde)
                matb[45] = '2'
            } else if (matb[45] == '2') {
                button_elect8ii.setBackgroundResource(R.drawable.elecing8iirojo)
                matb[45] = '3'
            }
        }
        button_elect8ii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva De Ingenieria")
            startActivity(intent)
            true
        }

        var button_elect8iii = findViewById(R.id.elecing8iii) as Button
        if (matb[46] == '1') {
            button_elect8iii.setBackgroundResource(R.drawable.elecing8iiiazul)
        } else if (matb[46] == '2') {
            button_elect8iii.setBackgroundResource(R.drawable.elecing8iiiverde)
        } else if (matb[46] == '3') {
            button_elect8iii.setBackgroundResource(R.drawable.elecing8iiirojo)
        }
        button_elect8iii.setOnClickListener {
            if (matb[46] == '3') {
                button_elect8iii.setBackgroundResource(R.drawable.elecing8iii)
                matb[46] = '0'
            } else if (matb[46] == '0') {
                button_elect8iii.setBackgroundResource(R.drawable.elecing8iiiazul)
                matb[46] = '1'
            } else if (matb[46] == '1') {
                button_elect8iii.setBackgroundResource(R.drawable.elecing8iiiverde)
                matb[46] = '2'
            } else if (matb[46] == '2') {
                button_elect8iii.setBackgroundResource(R.drawable.elecing8iiirojo)
                matb[46] = '3'
            }
        }
        button_elect8iii.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva De Ingenieria")
            startActivity(intent)
            true
        }

        var etica = findViewById(R.id.etica) as Button
        if (matb[47] == '1') {
            etica.setBackgroundResource(R.drawable.eticaazul)
        } else if (matb[47] == '2') {
            etica.setBackgroundResource(R.drawable.eticaverde)
        } else if (matb[47] == '3') {
            etica.setBackgroundResource(R.drawable.eticarojo)
        }
        etica.setOnClickListener {
            if (matb[47] == '3') {
                etica.setBackgroundResource(R.drawable.etica)
                matb[47] = '0'
            } else if (matb[47] == '0') {
                etica.setBackgroundResource(R.drawable.eticaazul)
                matb[47] = '1'
            } else if (matb[47] == '1') {
                etica.setBackgroundResource(R.drawable.eticaverde)
                matb[47] = '2'
            } else if (matb[47] == '2') {
                etica.setBackgroundResource(R.drawable.eticarojo)
                matb[47] = '3'
            }
        }
        etica.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Etica y Profesionalismo")
            startActivity(intent)
            true
        }

        var button_practica = findViewById(R.id.practica) as Button
        if (matb[48] == '1') {
            button_practica.setBackgroundResource(R.drawable.practicaazul)
        } else if (matb[48] == '2') {
            button_practica.setBackgroundResource(R.drawable.practicaverde)
        } else if (matb[48] == '3') {
            button_practica.setBackgroundResource(R.drawable.practicarojo)
        }
        button_practica.setOnClickListener {
            if (matb[48] == '3') {
                button_practica.setBackgroundResource(R.drawable.practica)
                matb[48] = '0'
            } else if (matb[48] == '0') {
                button_practica.setBackgroundResource(R.drawable.practicaazul)
                matb[48] = '1'
            } else if (matb[48] == '1') {
                button_practica.setBackgroundResource(R.drawable.practicaverde)
                matb[48] = '2'
            } else if (matb[48] == '2') {
                button_practica.setBackgroundResource(R.drawable.practicarojo)
                matb[48] = '3'
            }
        }
        button_practica.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Practica Profesional")
            startActivity(intent)
            true
        }

        var button_elect9 = findViewById(R.id.elecing9) as Button
        if (matb[49] == '1') {
            button_elect9.setBackgroundResource(R.drawable.electing9azul)
        } else if (matb[49] == '2') {
            button_elect9.setBackgroundResource(R.drawable.electing9verde)
        } else if (matb[49] == '3') {
            button_elect9.setBackgroundResource(R.drawable.electing9rojo)
        }
        button_elect9.setOnClickListener {
            if (matb[49] == '3') {
                button_elect9.setBackgroundResource(R.drawable.electing9)
                matb[49] = '0'
            } else if (matb[49] == '0') {
                button_elect9.setBackgroundResource(R.drawable.electing9azul)
                matb[49] = '1'
            } else if (matb[49] == '1') {
                button_elect9.setBackgroundResource(R.drawable.electing9verde)
                matb[49] = '2'
            } else if (matb[49] == '2') {
                button_elect9.setBackgroundResource(R.drawable.electing9rojo)
                matb[49] = '3'
            }
        }
        button_elect9.setOnLongClickListener {
            val intent: Intent = Intent(this, Recordatorios::class.java)
            intent.putExtra("MATERIA", "Electiva de Ingenieria")
            startActivity(intent)
            true
        }







    }



}
