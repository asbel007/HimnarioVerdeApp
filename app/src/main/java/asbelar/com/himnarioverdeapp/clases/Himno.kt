package asbelar.com.himnarioverdeapp.clases

/**
 * Created by Asbel Cami on 01/12/2017.
 */

class Himno{

    var imagen :Int?=null
    var titulo : String? = null
    var descripcion : String? = null

    constructor(imagen : Int, titulo: String, descripcion: String){
        this.imagen = imagen
        this.titulo = titulo
        this.descripcion = descripcion
    }
}
