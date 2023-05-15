export class persona{
     id?: number;
     nombre: String;
     apellido: String | undefined;
     img: String;

     constructor(nombre: String, apelido: String, img: String) {
        this.nombre = nombre;
        this.apellido = this.apellido;
        this.img = img;
     }

}
