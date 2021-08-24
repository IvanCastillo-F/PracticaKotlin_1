package com.example.practicakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

/*// TEXTVIEW

       // txvInfo.setText("")*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private lateinit var txvInfo: TextView
    var i:Int = 0
    var num: Int = 3
    var animal1 = Animal(1,"JuanitoPerez", "Steak",2,"Akita","dog" )
    var animal2 = Animal(2,"Jake", "Meatballs",5,"chihuahua","dog" )
    var animal3 = Animal(3,"Rufus", "deez nuts",6,"bulldog","dog" )
    var animal4 = Animal(4,"Cat with boots", "Tuna",2,"Ragdoll","cat" )
    var animal5 = Animal(5,"Timmy", "Fish",5,"Savannah","cat" )
    var animal6 = Animal(6,"Sanders", "Soup",2,"Munchkin","cat" )
    val MypetList = mutableListOf<Animal>(animal1,animal2,animal1,animal1,animal1,animal1)


  class Animal{
    var idAnimal: Int = 0
    var Name: String = ""
    var Food: String = ""
    var Age: Int = 0
    var Raze: String = ""
    var Animal: String = ""

    constructor(id:Int, name:String, food:String, age:Int, raze:String, animal:String){
        this.idAnimal = id
        this.Name = name
        this.Food = food
        this.Age = age
        this.Raze = raze
        this.Animal = animal
    }

      fun feedAnimal(): String{
          var txt = ""
          if(Animal.equals("dog")){
              txt = Name + " is eating "+ Food
          }else if(Animal.equals("cat")){
              txt = Name + " is eating " + Food
          }else{
              txt = "this animal is unknown for me"
          }
          return txt
      }

      fun playWithAnimal(): String{
          var txt = ""
          if(Animal.equals("dog")){
              txt = Name + " is playing with his favorite ball"
          }else if(Animal.equals("cat")){
              txt = Name + " is playing with a pieze of yarn"
          }else{
              txt = "mmmmm i dont known this animal"
          }
          return txt
      }

      fun Animalsounds(): String{
          var txt = ""
          if(Animal.equals("dog")){
              txt = "bark bark"
          }else if(Animal.equals("cat")){
              txt = "meow meow"
          }else{
              txt = "mmmmm i dont known how this animal sounds"
          }
          return txt
      }
}



    fun createNewPet(view: View) {
        //No supe como hacer funcionar este boton bien :,c
        if(num == 3){
            MypetList.add(2,animal3)
            num++
        }else if(num == 4){
            MypetList.add(3,animal4)
            num++
        }else if(num == 5){
            MypetList.add(4,animal5)
            num++
        }else if(num == 6){
            MypetList.add(5,animal6)
            num++
        }

        txvInfo = findViewById(R.id.txvInfo)
        txvInfo.text = "Your animal is " + MypetList[num-1].Animal+ "\n"+"Its name is "+ MypetList[num-1].Name+
                "\n"+"Its age is " + MypetList[num-1].Age+ "\n"+"and its raze is " + MypetList[num-1].Raze

    }

    fun getNextPet(view: View) {
        if(i< MypetList.size && i >= 0){

            txvInfo = findViewById(R.id.txvInfo)
            txvInfo.text = "Your animal is " + MypetList[i].Animal+ "\n"+"Its name is "+ MypetList[i].Name+
                    "\n"+"Its age is " + MypetList[i].Age+ "\n"+"and its raze is " + MypetList[i].Raze

        }else if (i > 5){
            Toast.makeText(this,"stop is no more pets", Toast.LENGTH_LONG).show()

        }
        i++
    }

    fun getPreviousPet(view: View) {
        if(i< MypetList.size && i >= 0){

            txvInfo = findViewById(R.id.txvInfo)
            txvInfo.text = "Your animal is " + MypetList[i].Animal+ "\n"+"Its name is "+ MypetList[i].Name+
                    "\n"+"Its age is " + MypetList[i].Age+ "\n"+"and its raze is " + MypetList[i].Raze

        }else if(i < 0){
            Toast.makeText(this,"stop is no more pets", Toast.LENGTH_LONG).show()

        }
        i--
    }

    fun eat(view: View) {
        Toast.makeText(this,MypetList[i-1].feedAnimal(), Toast.LENGTH_LONG).show()
    }

    fun makeSound(view: View) {
        Toast.makeText(this,MypetList[i-1].Animalsounds(), Toast.LENGTH_LONG).show()
    }
    fun play(view: View) {
        Toast.makeText(this,MypetList[i-1].playWithAnimal(), Toast.LENGTH_LONG).show()
    }
}