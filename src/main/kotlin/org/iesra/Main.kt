package org.iesra

import javax.lang.model.type.NullType


// Ejercicio 4.1
class Rectangulo(val base: Double, val altura: Double)
{
    init { if (base < 0 || altura < 0) throw Exception("Base y altura deben ser mayor a 0") }

    fun area(): Double { return base * altura }

    fun perimetro(): Double { return 2 * area() }

    override fun toString(): String { return "Rectangulo($base, $altura)" }
}


// Ejercicio 4.2 y 4.3
class Persona(var peso: Double, var altura: Double)
{
    enum class IMC { INSUFICIENTE, SALUDABLE, SOBREPESO, OBESIDAD }

    var nombre: String = ""
    val imc: Double = peso / (altura * altura)

    constructor(peso: Double, altura: Double, nombre: String): this(peso, altura)
    { this.nombre = nombre }

    override fun toString(): String { return "Persona($peso, $altura, $nombre, $imc)" }

    fun saludar(): String { return "Hola $nombre" }

    fun alturaEncimaMedia(): Boolean
    {
        if (altura >= 1.75) return true
        return false
    }

    fun pesoEncimaMedia(): Boolean
    {
        if (peso >= 1.70) return true
        return false
    }

    fun obtenerDescImc(): IMC?
    {
        if (imc <= 18.5) return IMC.INSUFICIENTE
        if (imc in 18.5..24.9) return IMC.SALUDABLE
        if (imc in 25.0..29.9) return IMC.SOBREPESO
        if (imc >= 30.0) return IMC.OBESIDAD
        return null
    }

    fun obtenerDesc(): String
    {
        return "$nombre con una altura de ${altura}m (${alturaEncimaMedia()}) y un peso ${peso}kg (${pesoEncimaMedia()}) tiene un IMC (${obtenerDescImc()})"
    }
}


// Ejercicio 4.4
class Coche(var color: String?, val marca: String, val modelo: String, val numCaballos: Int?, val numPuertas: Int?, val matricula: String?)
{
    var upperModelo: String? = modelo
        get() = field?.uppercase()
    var upperMarca: String? = modelo
        get() = field?.uppercase()

    init {
        if (marca.isNullOrEmpty() || modelo.isNullOrEmpty()) throw Exception("$marca y $modelo no pueden ser nulos o vacios")
        if (numCaballos == null || numPuertas == null || matricula == null || color == null) throw Exception("$numCaballos, $numPuertas, $matricula, $color no pueden ser nulos o vacios")
        if (matricula.length < 7) throw Exception("$marca tiene menos de 7 caracteres")
        if (numCaballos in 70..700) throw Exception("$numCaballos debe de estar [70, 700]")
        if (numPuertas !in 3..5) throw Exception("$numPuertas no debe de estar [3, 5]")
    }

    override fun toString(): String { return "Persona($color, $marca, $numCaballos, $matricula)" }
}



fun main()
{
    // Ejercicio 4.1
    val rectangulo: Rectangulo = Rectangulo(1.2, 3.5)
    println(rectangulo)
    println(rectangulo.area())
    println(rectangulo.perimetro())

    var input = readln()

    // Ejercicio 4.2
    val persona1: Persona = Persona(50.0, 1.7)
    if (input.isEmpty()) persona1.nombre = input
    println("Persona1: ${persona1.nombre}, ${persona1.peso}, ${persona1.altura}")

    val persona2: Persona = Persona(65.0, 1.9)
    persona2.toString()
    persona2.altura = 1.8
    persona2.toString()

    val persona3: Persona = Persona(89.0, 1.6)
    persona3.altura = persona2.altura
    persona2.toString()
    persona3.toString()
    if (persona2.equals(persona3)) println("Son iguales")


    // Ejercicio 4.3
    // Lo mismo que antes

    // Ejercicio 4.4
    // Lo mismo que antes
}