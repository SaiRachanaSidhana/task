package com.example.task

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class adduserActivity : AppCompatActivity() {
    val courses = arrayOf("","Java","Python","Kotlin","C")
    private var tvSelectedDate : TextView? = null
    private var tvselectdatetime : TextView? = null
    private var btndatetime : Button? = null

    private var etName : EditText? = null

    private var btnsubmit : Button?= null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)

        etName = findViewById(R.id.etName)
        var btnsubmit = findViewById<Button>(R.id.btnsubmit)
        btnsubmit?.setOnClickListener{
            when{
                etName?.text?.isEmpty() == true ->
                    Toast.makeText(this,"Name is not Filled", Toast.LENGTH_SHORT).show()
                tvSelectedDate?.text?.equals("Select DOB date")==true ->
                    Toast.makeText(this,"DOB is Not Selected", Toast.LENGTH_SHORT).show()
                tvselectdatetime?.text?.equals("Select Date and Time")==true ->
                    Toast.makeText(this,"Date and Time is Not Selected", Toast.LENGTH_SHORT).show()

                true->{
                    Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                }



            }
        }


        val btnDatePicker = findViewById<ImageButton>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            clickDatePicker()



        }
        tvselectdatetime = findViewById(R.id.tvselectdatetime)
        val btndatetime = findViewById<ImageButton>(R.id.btndatetime)

        btndatetime?.setOnClickListener {
            clickDateandTimePicker()

        }




        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        var rbt = findViewById<RatingBar>(R.id.ratingBar)
        rbt.rating = 2.5f
        rbt.stepSize = .5f

        rbt.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this,"Rating: $rating", Toast.LENGTH_SHORT).show()
        }

        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,courses)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,"selected course is "+courses[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val r1 = findViewById<RadioButton>(R.id.radioButton)
        val r2 = findViewById<RadioButton>(R.id.radioButton1)
        r1.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Male is selected", Toast.LENGTH_SHORT).show()
        }
        r2.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Female is selected", Toast.LENGTH_SHORT).show()
        }

        val chk = findViewById<CheckBox>(R.id.checkBox)
        val chk2 = findViewById<CheckBox>(R.id.checkBox2)
        val chk3 = findViewById<CheckBox>(R.id.checkBox3)
        val chk4 = findViewById<CheckBox>(R.id.checkBox4)

        chk.setOnClickListener(View.OnClickListener {
            if(chk.isChecked){
                Toast.makeText(this,"2023 passed out", Toast.LENGTH_SHORT).show()
            }
        })
        chk2.setOnClickListener(View.OnClickListener {
            if(chk2.isChecked){
                Toast.makeText(this,"2022 passed out", Toast.LENGTH_SHORT).show()
            }
        })
        chk3.setOnClickListener(View.OnClickListener {
            if(chk3.isChecked){
                Toast.makeText(this,"2021 passed out", Toast.LENGTH_SHORT).show()
            }
        })
        chk4.setOnClickListener(View.OnClickListener {
            if(chk4.isChecked){
                Toast.makeText(this,"2020 passed out", Toast.LENGTH_SHORT).show()
            }
        })


        val r3 = findViewById<RadioButton>(R.id.radioButton2)
        val r4 = findViewById<RadioButton>(R.id.radioButton3)
        val r5 = findViewById<RadioButton>(R.id.radioButton4)
        val r6 = findViewById<RadioButton>(R.id.radioButton5)
        val r7 = findViewById<RadioButton>(R.id.radioButton6)
        val r8 = findViewById<RadioButton>(R.id.radioButton7)

        r3.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 1", Toast.LENGTH_SHORT).show()
        }
        r4.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 2", Toast.LENGTH_SHORT).show()
        }
        r5.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 3", Toast.LENGTH_SHORT).show()
        }
        r6.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 4", Toast.LENGTH_SHORT).show()
        }
        r7.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 5", Toast.LENGTH_SHORT).show()
        }
        r8.setOnCheckedChangeListener{buttonView,isChecked ->
            Toast.makeText(this,"Yourself rated as 1", Toast.LENGTH_SHORT).show()
        }


    }



    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this,
                    "Year was selected $year,month was selected ${month+1},day was selected $selectedDayOfMonth",
                    Toast.LENGTH_LONG).show()


                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                tvSelectedDate?.text = selectedDate


            },
            year,
            month,
            day).show()}

    fun clickDateandTimePicker(){

        val cal= Calendar.getInstance()
        val year=cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val dpg= DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, sday ->

            val selectedDate="$sday-${month+1}-$year"

            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val min = cal.get(Calendar.MINUTE)

            TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener{ view, hour, min->
                    val selectedtime = "$hour:$min"

                    tvselectdatetime?.text = "$selectedDate | $selectedtime"
                    Toast.makeText(this,
                        "Year was selected $year,month was selected ${month+1},day was selected $sday,hour is $hour,minutes is $min",
                        Toast.LENGTH_LONG).show()

                },
                hour,
                min,
                true
            ).show()


        },
            year,
            month,
            day)
        dpg.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpg.show()
    }
}