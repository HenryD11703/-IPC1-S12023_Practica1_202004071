/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.Scanner;
import java.time.Instant;//para la fecha 
import java.util.Date;//y la hora para la factura

/**
 *
 * @author henry
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    Date date = Date.from(Instant.now());
    Scanner entrada = new Scanner(System.in);
    Scanner ints = new Scanner(System.in);
    public String[] prods = new String[10];
    int[] precs = new int[10];
    String[] cupon = new String[10];
    int[] descuento = new int[10];
    String[] prodsc = new String[20];
    int[] precsc = new int[20];
    boolean existe = false;
    boolean existe1 = false;
    String nt;
    Double Sumatotal = 0.0;
    int contador = 0;
    public String[] Pvendidos = new String[20];
    public int contadorventas = 0;
    public String[] Historial = new String[20];

    public void Logeo() {

        String Usuario = "", Contra = "";
        while (!Usuario.equals("cajero_202004071") || !Contra.equals("ipc1_202004071")) {//cambiar a los datos en la practica
            System.out.println("------Logeo de Usuario------");
            System.out.println("Ingrese su nombre de Usuario: ");
            Usuario = entrada.nextLine();
            System.out.println("Ingrese su contraseña ");
            Contra = entrada.nextLine();

        }

    }

    public void Menu() {
        int eleccion;
        do {
            System.out.println("------Menu de Acciones------");
            System.out.println("Seleccione una opcion a realizar");
            System.out.println("1. Agregar nuevos Productos");
            System.out.println("2. Agregar cupones de descuento");
            System.out.println("3. Realizar ventas");
            System.out.println("4. Realizar Reporte");
            System.out.println("5. Salir.");
            eleccion = ints.nextInt();
            switch (eleccion) {
                case 1:

                    int opcion = 0;
                    do {
                        System.out.println("---- Agregar Producto ----");
                        System.out.println("Ingrese nombre del producto: ");
                        String prod = entrada.nextLine();
                        System.out.println("Ingrese precio del producto:");
                        int prec = ints.nextInt();
                        if (prec > 0) {

                            for (String prod1 : prods) {
                                if (prod1 != null) {
                                    if (prod1.equals(prod)) {
                                        existe = true;
                                        System.out.println("El producto ya fue agregado previamente");
                                        break;
                                    }
                                }
                            }
                            if (!existe) {
                                prods[contador] = prod;
                                precs[contador] = prec;
                                contador++;

                            }
                            System.out.println("1. Agregar otro Producto | 2. Salir al menu principal");
                            opcion = ints.nextInt();

                        } else {
                            System.out.println("El precio del producto debe ser mayor que cero");
                        }
                        if (opcion == 3) {
                            for (int a = 0; a < prods.length; a++) {
                                System.out.println(a + 1 + ". " + prods[a] + " - " + precs[a]);
                            }
                        }
                    } while (opcion != 2);
                    break;
                case 2:
                    int opcion2 = 0;
                    int contador1 = 0;
                    while (opcion2 != 2) {
                        System.out.println("---- Agregar cupon de descuento ----");
                        System.out.println("Codigo del cupon: ");
                        entrada = new Scanner(System.in);
                        String cupons = entrada.nextLine();
                        System.out.println("Porcentaje de descuento ");
                        int desc = ints.nextInt();
                        char[] arr = cupons.toCharArray();

                        if (arr.length != 4) {
                            System.out.println("El codigo del cupon tiene que ser de 4 digitos");

                        } else if (desc < 0 || desc > 100) {
                            System.out.println("El descuento debe tener el rango de 0 - 100");
                        } else {
                            
                            //Si el else es correcto agregar el dato a la matriz     

                            for (int i = 0; i < cupon.length; i++) {
                                if (cupon[i] != null) {
                                    if (cupon[i].equals(cupons)) {
                                        existe1 = true;
                                        System.out.println("El cupon ya existe");
                                        break;
                                    }
                                }
                            }
                            if (!existe1) {
                                cupon[contador1] = cupons;
                                descuento[contador1] = desc;
                                contador1++;
                            }

                        }
                        System.out.println("1. Agregar otro Cupon | 2. Salir al menu principal");
                        opcion2 = entrada.nextInt();
                    }
                    break;
                case 3:
                    int contador;
                    contador = 0;
                    int nproducto = 0,
                     elventa = 0;
                    String t;
                    int Sm;
                    System.out.println("----Comprar Productos----");
                    System.out.println("Ingrese su nombre: ");
                    entrada = new Scanner(System.in);
                    String ncliente = entrada.nextLine();
                    System.out.println("Ingrese numero de nit o deje en blanco si no tiene:  ");
                    String nit = entrada.nextLine();
                    if (nit == "") {
                        nt = "CF";
                    } else {
                        nt = nit;
                    }

                    System.out.println("Nombre: " + ncliente + " Nit: " + nt);
                    System.out.println("");
                    System.out.println("---Seleccione productos para comprar---");
                    while (elventa != 2) {

                        for (int a = 0; a < prods.length; a++) {
                            if (prods[a] != null) {
                                System.out.println(a + 1 + ". " + prods[a] + " - " + precs[a]);
                            }

                        }

                        System.out.println("Ingrese el numero del producto que desea comprar:  ");
                        nproducto = entrada.nextInt();

                        prodsc[contador] = prods[nproducto - 1];
                        precsc[contador] = precs[nproducto - 1];
                        contador++;
                        Sm = precs[nproducto - 1];

                        Sumatotal += Sm;

                        System.out.println("Suma total : " + Sumatotal);

                        System.out.println("1. Seguir comprando 2.Terminar compra ");
                        elventa = ints.nextInt();
                    }
                    if (elventa == 2) {
                        System.out.println("Tiene un codigo de descuento?");
                        System.out.println("1. Si           2. No");
                        int des = ints.nextInt();

                        //aplicar el codigo de descuento a Sumatotal
                        if (des == 1) {//factura con descuento
                            int pos = -1;
                            System.out.println("Ingrese su codigo de descuento");
                            entrada = new Scanner(System.in);
                            String cod = entrada.nextLine();

                            for (int i = 0; i < cupon.length; i++) {
                                if (cupon[i] == null ? cod == null : cupon[i].equals(cod)) {
                                    pos = i;
                                }
                            }
                            if (pos == -1) {
                                System.out.println("El codigo Introducido no existe");
                            } else {
                                System.out.println("El codigo " + cod + " tiene un descuento de: " + descuento[pos] + "%");
                                Double Sumadesc = Sumatotal - (Sumatotal * (descuento[pos]) / 100);
                                System.out.println("Por lo que su compra de " + Sumatotal + " queda con un valor de: " + Sumadesc);

                                System.out.println("");
                                System.out.println("");
                                System.out.println("---- Facturacion ----");
                                System.out.println("Empresa: SUPER-25");
                                System.out.println("Cajero: Henry David Quel Santos");
                                System.out.println("Cliente: " + ncliente + " Con Nit: " + nt);
                                System.out.println("Con fecha: " + date);
                                System.out.println("---- Listado de Productos Comprados ----");

                                for (int i = 0; i < 10; i++) {
                                    if (prodsc[i] != null) {
                                        System.out.println(i + 1 + ". " + prodsc[i] + "- Q" + precsc[i]);
                                    }
                                }
                                System.out.println("Subtotal: Q" + Sumatotal);
                                System.out.println("Descuento aplicado: %" + descuento[pos]);
                                System.out.println("Precio total: Q" + Sumadesc);
                                System.out.println("---- Finalizacion de factura ----");

                            }

                            break;
                        } // si no tiene codigo de descuento imprimir la factura solamente
                        else {
                            System.out.println("---- Facturacion ----");
                            System.out.println("Empresa: SUPER-25");
                            System.out.println("Cajero: Henry David Quel Santos");
                            System.out.println("Cliente: " + ncliente + " Con Nit: " + nt);
                            System.out.println("Con fecha: " + date);
                            System.out.println("---- Listado de Productos Comprados ----");

                            for (int i = 0; i < prodsc.length; i++) {
                                if (prodsc[i] != null) {
                                    System.out.println(i + 1 + ". " + prodsc[i] + "- Q" + precsc[i]);
                                }
                            }
                            System.out.println("Total: Q" + Sumatotal);

                            System.out.println("---- Finalizacion de factura ----");

                        }

                    }
                    break;
                case 4:
                    System.out.println("--- Reporte de Ventas ---");
                    System.out.println("Los productos mas vendidos son:");
                    int[] repeticiones = new int[prodsc.length];
                    int reps = -1;
                    for (int i = 0; i < prodsc.length; i++) {
                        int contador4 = 1;
                        for (int j = i + 1; j < prodsc.length; j++) {
                            if (prodsc[i] == prodsc[j]) {
                                contador4++;
                                repeticiones[j] = reps;
                            }
                        }
                        if (repeticiones[i] != reps) {
                            repeticiones[i] = contador4;
                        }
                    }

                    System.out.println(" Producto y Cantidad vendida");
                    System.out.println("----------------------------");
                    for (int i = 0; i < repeticiones.length; i++) {
                        if (repeticiones[i] != reps) {
                            if (prodsc[i] != null) {
                                System.out.println("El producto "+ prodsc[i] + "    Se vendio   " + repeticiones[i]);
                            }

                        }
                    }

                    // prodsc[] son los comprados y en prods[] son los que estan añadidos
                    //en prodsc[] se almacenan los nombres de todos los vendidos, solo contabilizar cuantas veces se repiten e 
                    //imprimirlos de mayor a menor
//                    Para ver el listado de productos vendidos con sus precios
//                    for (int i = 0; i < prodsc.; i++) {
//                                if (prodsc[i] != null) {
//                                    System.out.println(i + 1 + ". " + prodsc[i] + "- Q" + precsc[i]);
//                                }
//                            }
                    break;
                default:
                    System.out.println("Elegir una opcion valida");
            }

        } while (eleccion != 5);

    }

    public static void main(String[] args) {
        JavaApplication3 clas = new JavaApplication3();
        clas.Logeo();
        clas.Menu();

    }

}
