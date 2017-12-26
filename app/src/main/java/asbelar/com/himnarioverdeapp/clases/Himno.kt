package asbelar.com.himnarioverdeapp.clases

/**
 * Created by Asbel Cami on 01/12/2017.
 */

class Himno{

    var imagen :Int?=null
    var numero :Int?=null
    var tituloEs : String? = null
    var tituloQch : String? = null
    var alabanzaEs : String? = null
    var alabanzaQch : String? = null
    var coroEs : String? = null
    var coroQch : String? = null


    constructor(imagen : Int, numero: Int, tituloEs: String, tituloQch: String, alabanzaEs: String, alabanzaQch: String){
        this.imagen = imagen
        this.numero = numero
        this.tituloEs = tituloEs
        this.tituloQch = tituloQch
        this.alabanzaEs = alabanzaEs
        this.alabanzaQch = alabanzaQch
        this.coroEs = "coroEs"
        this.coroQch = "coroQch"

    }
}
