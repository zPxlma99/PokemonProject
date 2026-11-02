package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import logica.Carta;
import logica.pokemones.*;
import logica.CartasEntrenador.*;
import java.util.Scanner;
import java.util.function.Supplier;
import logica.CartasEntrenador.InvestProfe;
public class App {





    
    

private static void agregar(ArrayList<Carta> mazo, Supplier<Carta> carta, int copias) {
    for (int i = 0; i < copias; i++) {
        mazo.add(carta.get());  
    }
}


public static ArrayList<Carta> mazo1() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Articuno::new, 2);
    agregar(mazo, Squirtle::new, 2);
    agregar(mazo, Magikarp::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Mewtwo::new, 2);
    agregar(mazo, Misty::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazo2() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Moltres::new, 2);
    agregar(mazo, Charmander::new, 2);
    agregar(mazo, pikachu::new, 2);
    agregar(mazo, Squirtle::new, 2);
    agregar(mazo, Zapdos::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}

public static ArrayList<Carta> mazo3() {
    ArrayList<Carta> mazo = new ArrayList<>();
    agregar(mazo, Zapdos::new, 1);
    agregar(mazo, Mewtwo::new, 1);
    agregar(mazo, pikachu::new, 2);
    agregar(mazo, Charmander::new, 2);
    agregar(mazo, Magikarp::new, 2);
    agregar(mazo, Jigglypuff::new, 2);
    agregar(mazo, Snorlax::new, 2);
    agregar(mazo, Pocion::new, 2);
    agregar(mazo, Pokebola::new, 2);
    agregar(mazo, InvestProfe::new, 2);
    agregar(mazo, TurboVelocidad::new, 2);
    return mazo;
}
public static void mostrarMazos(ArrayList<Carta> mazo1, ArrayList<Carta> mazo2, ArrayList<Carta> mazo3) {
    System.out.printf("%-15s %-15s %-15s%n", "mazo 1", "mazo 2", "mazo 3");
    for (int i = 0; i < mazo1.size(); i++) {
        System.out.printf("%-15s %-15s %-15s%n",
                mazo1.get(i).getNombreCarta(),
                mazo2.get(i).getNombreCarta(),
                mazo3.get(i).getNombreCarta());
    }}
public Jugador CrearJugador(int opc, String nombreJugador, ArrayList<Carta> mazo1, ArrayList<Carta> mazo2, ArrayList<Carta> mazo3) {
    switch (opc) {
        case 1:
            ArrayList<Carta> mazoElegido = new App().mazo1();
            ArrayList<Carta> manoJugador1 = new ArrayList<>();
            manoJugador1 = CrearManoInicial(mazoElegido);

            return new Jugador(nombreJugador, 0, mazoElegido, manoJugador1, 0);
        case 2:
            ArrayList<Carta> mazoElegido2 = new App().mazo2();
            ArrayList<Carta> manoJugador2 = new ArrayList<>();
            manoJugador2 = CrearManoInicial(mazoElegido2);
            return new Jugador(nombreJugador, 0, mazoElegido2, manoJugador2, 0  );
        case 3:
            ArrayList<Carta> mazoElegido3 = new App().mazo3();
            ArrayList<Carta> manoJugador3 = new ArrayList<>();
            manoJugador3 = CrearManoInicial(mazoElegido3);
            return new Jugador(nombreJugador, 0, mazoElegido3, manoJugador3, 0);
        default:
            System.out.println("Opción inválida.");
            System.out.println("ingrese de nuevo la opción del mazo (1, 2 o 3):");
            Scanner scanner = new Scanner(System.in);
            int opcionMazo = scanner.nextInt();
            return CrearJugador(opcionMazo, nombreJugador, mazo1, mazo2, mazo3);  
    }
}
public static int valorRandom( ArrayList<Carta> mazo){
    Random rand = new Random(); 
    int num = rand.nextInt(mazo.size()); 
    return num;
}

public static int mostrarAcciones(){
    System.out.println("Acciones disponibles:");
    System.out.println("1.Adjuntar energía de zona");
    System.out.println("2.Jugar carta de entrenador");
    System.out.println("3.Colocar Pokémon en banco");
    System.out.println("4. Retirar Pokémon activo") ;
    System.out.println("5. Atacar");
    System.out.println("6. Pasar turno");
    System.out.println("Ingrese el número de la acción que desea realizar:");
    Scanner scanner = new Scanner(System.in);
    int accion = scanner.nextInt();
    if (accion < 1 || accion > 6) {
        System.out.println("Acción inválida. Por favor, ingrese un número del 1 al 6.");
        return mostrarAcciones(); 

    }
    
    return accion;
}

public static void jugarCartaEntrenador(Jugador jugador) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione la carta de entrenador que desea jugar:");
    for (int i = 0; i < jugador.getMano().size(); i++) {
        Carta carta = jugador.getMano().get(i);
        if (carta.getTipoCarta() == TipoCarta.ENTRENADOR) {
            System.out.println((i + 1) + ". " + carta.getNombreCarta());
        }
        System.out.println("Ingrese el número de la carta que desea jugar:");
        int opcEntrenador = scanner.nextInt();
        if (jugador.getMano().get(opcEntrenador - 1).getTipoCarta() != TipoCarta.ENTRENADOR) {
            System.out.println("La carta seleccionada no es una carta de entrenador. Por favor, seleccione una carta válida.");
            return;

        }

            
           
        
        

    }
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > jugador.getMano().size()) {
        System.out.println("Opción inválida. Por favor, seleccione una carta válida.");
        return;
    }
    Carta cartaSeleccionada = jugador.getMano().get(opcion - 1);
    if (cartaSeleccionada instanceof CartaEntrenador) {
        
        jugador.getMano().remove(cartaSeleccionada);
        System.out.println("Carta de entrenador " + cartaSeleccionada.getNombreCarta() + " jugada con éxito.");
    } else {
        System.out.println("La carta seleccionada no es una carta de entrenador.");
    }
}



public static void adjuntarEnergia(Jugador jugador) {
    if (jugador.getEnergy() > 0) {
        Scanner scanner = new Scanner(System.in);
        
        int cantidadOp= (jugador.getPokemonActivo()!=null ? 1 : 0) + jugador.getBanco().length;
        System.out.println("Seleccione a qué Pokémon desea adjuntar la energía:");
        for (int i=0; i<cantidadOp; i++) {
            if (i==0){
                System.out.print(i+1+": "+ jugador.getPokemonActivo().getNombreCarta());
            } else {
                System.out.print(i+1+": "+ jugador.getBanco()[i-1].getNombreCarta());
            }
            int opcionAdjuntar = scanner.nextInt();

            switch (opcionAdjuntar) {
                case 1:
                    jugador.setEnergy(0);
                    jugador.getPokemonActivo().setEnergiaAcumulada(jugador.getPokemonActivo().getEnergiaAcumulada() + 1);

                    break;
                case 2:
                    jugador.setEnergy(0);
                    jugador.getBanco()[0].setEnergiaAcumulada(jugador.getBanco()[0].getEnergiaAcumulada() + 1);
                case 3:
                    jugador.setEnergy(0);
                    jugador.getBanco()[1].setEnergiaAcumulada(jugador.getBanco()[1].getEnergiaAcumulada() + 1);
                    break;
                case 4:
                    jugador.setEnergy(0);
                    jugador.getBanco()[2].setEnergiaAcumulada(jugador.getBanco()[2].getEnergiaAcumulada() + 1);
                    break;
        
                default:
                    System.out.println("Opción inválida. Por favor, seleccione un Pokémon válido.");
                    adjuntarEnergia(jugador);
                    break;
        }
    }
}     
        else {
            System.out.println("No hay energía disponible para adjuntar.");
        }
}

public static ArrayList<Carta> CrearManoInicial(ArrayList<Carta> mazo){
    ArrayList<Carta> mano = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        int num = valorRandom(mazo);
        Carta c = mazo.get(num);
        mano.add(c);
        mazo.remove(num);
    }
    return mano;
}
public static void mostrarMano(Jugador jugador) {
    System.out.println("Mano del jugador: " + jugador.getNombre());
    for (Carta carta : jugador.getMano()) {
        System.out.println(carta.getNombreCarta());
    }
}
public static void mostrarBanco(Jugador jugador) {
    if (jugador.getBanco()[0] == null && jugador.getBanco()[1] == null && jugador.getBanco()[2] == null) {
        System.out.println("El banco del jugador " + jugador.getNombre() + " está vacío.");
        return;
    }else{
        System.out.println("Banco del jugador: " + jugador.getNombre());
    for (int i=0; i<jugador.getBanco().length; i++) {
        System.out.println(jugador.getBanco()[i].getNombreCarta());
    }

    }
    
}
public static void mostrarDatos(Jugador jugador) {
    System.out.println("Pokemon activo: " + (jugador.getPokemonActivo() != null ? jugador.getPokemonActivo().getNombreCarta() : "Ninguno"));
    System.out.println("Energia adjunta al pokemon activo: " + (jugador.getPokemonActivo() != null ? jugador.getPokemonActivo().getEnergiaAcumulada() : 0));
    mostrarBanco(jugador);
    System.out.println("Puntos de premio: " + jugador.getPuntos()+"/3");
}
public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carta> mazo1 = mazo1();
        ArrayList<Carta> mazo2 = mazo2();    
        ArrayList<Carta> mazo3 = mazo3();

    System.out.println("------------Pokemon TCG Univalle-------------");
    System.out.println("Bienvenido al juego de cartas Pokemon TCG Univalle");
        System.out.println("Ingrese el nombre del jugador 1:");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 2:");
        String nombreJugador2 = scanner.nextLine(); 
        mostrarMazos(mazo1, mazo2, mazo3);
        System.out.println("Jugador: " + nombreJugador1 + ", elija su mazo (1, 2 o 3):");
        int opcionMazoJugador1 = scanner.nextInt();
        Jugador jugador1 = new App().CrearJugador(opcionMazoJugador1, nombreJugador1, mazo1, mazo2, mazo3);
        System.out.println("Jugador: " + nombreJugador2 + ", elija su mazo (1, 2 o 3):");
        int opcionMazoJugador2 = scanner.nextInt();
        Jugador jugador2 = new App().CrearJugador(opcionMazoJugador2, nombreJugador2, mazo1, mazo2, mazo3);
        int turno = 0;
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("Turno: " + (turno + 1));
            System.out.println("--------------------------------------------------");

            if (turno % 2 == 0) {

                if (jugador1.getEnergy() < 1) {
                    jugador1.setEnergy(1);
                }
                System.out.println("RIVAL: (" + jugador2.getNombre() + ")");
                mostrarDatos(jugador2);
                
                System.out.println("TU CAMPO: (" + jugador1.getNombre() + ")");
                mostrarDatos(jugador1);
                
                turno++;
            } else {
    
                if (jugador1.getEnergy() < 1) {
                    jugador1.setEnergy(1);
                }
                System.out.println("RIVAL: (" + jugador1.getNombre() + ")");
                mostrarDatos(jugador1);
                
                System.out.println("TU CAMPO: (" + jugador2.getNombre() + ")");
                mostrarDatos(jugador2);
                
                turno++;
                turno++;
            }  
            


        }
        while(jugador1.getMazo().size() > 0 && jugador2.getMazo().size() > 0 && jugador1.getPuntos() < 3 && jugador2.getPuntos() < 3 && turno<6);


    }
}


