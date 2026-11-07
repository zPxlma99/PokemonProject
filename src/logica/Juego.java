package logica;
import java.util.ArrayList;
import java.util.Random;
import logica.CartasEntrenador.*;
import java.util.Scanner;

public class Juego {

    //FALTA HACER LA LOGICA DE ATAQUE, DE FINAL DE COMBATE Y VICTORIA AL LLEGAR A 3 PUNTOS
    private static final int MAX_TURNOS = 6;

public static int valorRandom( ArrayList<Carta> mazo){
    Random rand = new Random(); 
    int num = rand.nextInt(mazo.size()); 
    return num;
}

////////////////////////////crea jugador/////////////////////////////

public static Jugador crearJugador(int opc, String nombre, Scanner scanner) {
    ArrayList<Carta> mazo = null;
    while (mazo == null) {
        switch (opc) {
            case 1: mazo = CreadorMazosPDefecto.mazo1(); break;
            case 2: mazo = CreadorMazosPDefecto.mazo2(); break;
            case 3: mazo = CreadorMazosPDefecto.mazo3(); break;
            default:
                System.out.println("Opción inválida. Ingrese de nuevo (1, 2 o 3):");
                opc = scanner.nextInt();
        }
    }
    ArrayList<Carta> mano = CrearManoInicial(mazo);
    return new Jugador(nombre, 0, mazo, mano, 0);
}


public static Pokemon elegirPokemonEnJuego(Jugador jugador, Scanner scanner) {
    ArrayList<Pokemon> opciones = new ArrayList<>();
    if (jugador.getPokemonActivo() != null) {
        opciones.add(jugador.getPokemonActivo());
    }
    for (Pokemon p : jugador.getBanco()) {
        if (p != null) {
            opciones.add(p);
        }
    }
    if (opciones.isEmpty()) {
        System.out.println("No tienes Pokémon en juego.");
        return null;
    }
    System.out.println("--------------------------------");
    for (int i = 0; i < opciones.size(); i++) {
        System.out.println((i + 1) + ". " + opciones.get(i).getNombreCarta());
    }
    System.out.println("--------------------------------");
    System.out.println("Elige el Pokémon:");
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > opciones.size()) {
        System.out.println("Opción inválida.");
        return null;
    }
    return opciones.get(opcion - 1);
}



public void iniciar() {
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("------------Pokemon TCG Univalle-------------");
    System.out.println("Bienvenido al juego de cartas Pokemon TCG Univalle");
    System.out.println("Ingrese el nombre del jugador 1:");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 2:");
        String nombreJugador2 = scanner.nextLine(); 
        CreadorMazosPDefecto.mostrarMazos(
        CreadorMazosPDefecto.mazo1(),
        CreadorMazosPDefecto.mazo2(),
        CreadorMazosPDefecto.mazo3());

    System.out.println("Jugador: " + nombreJugador1 + ", elija su mazo (1, 2 o 3):");
    int opcionMazoJugador1 = scanner.nextInt();
    Jugador jugador1 = crearJugador(opcionMazoJugador1, nombreJugador1, scanner);

    System.out.println("Jugador: " + nombreJugador2 + ", elija su mazo (1, 2 o 3):");
    int opcionMazoJugador2 = scanner.nextInt();
    Jugador jugador2 = crearJugador(opcionMazoJugador2, nombreJugador2, scanner);

        mostrarMano(jugador1);
        mostrarMano(jugador2);
        colocarPokemonInicial(jugador1, scanner);
        colocarPokemonInicial(jugador2, scanner);
        
        int turno = 0;
do {  
    System.out.println("--------------------------------------------------");
    System.out.println("Turno: " + (turno + 1));
    System.out.println("--------------------------------------------------");

    Jugador actual = (turno % 2 == 0) ? jugador1 : jugador2;
    Jugador rival = (turno % 2 == 0) ? jugador2 : jugador1;
    if (turno >= 2) {
        // CAMBIO: se valida que el mazo no esté vacío antes de robar
        if (!actual.getMazo().isEmpty()) {
            actual.getMano().add(actual.getMazo().remove(0));
            System.out.println(actual.getNombre() + " ha robado una carta: " + actual.getMano().get(actual.getMano().size() - 1).getNombreCarta());
        } else {
        System.out.println(actual.getNombre() + " no puede robar una carta, el mazo está vacío.");
        System.out.println(actual.getNombre() + " no puede continuar el juego, el mazo está vacío.");
        System.out.println(rival.getNombre() + " gana el juego.");
        return;
        }
    }

    if (actual.getEnergy() < 1) {
        actual.setEnergy(1);
    }

    System.out.println("RIVAL: (" + rival.getNombre() + ")");
    mostrarDatos(rival);

    System.out.println("TU CAMPO: (" + actual.getNombre() + ")");
    mostrarDatos(actual);
    System.out.println("--------------------------------------------------");

    
    int accion = 0;
    do {
        accion = mostrarAcciones(scanner);
        switch (accion) {
            case 1:
                adjuntarEnergia(actual, scanner);
                break;
            case 2:
                jugarCartaEntrenador(actual, scanner);
                break;
            case 3:
                colocarPokemonBanco(actual, scanner);
                break;
            case 4:
                retirarPokemonActivo(actual, scanner);
                break;
            case 5:
                if (actual.getPokemonActivo() != null) {
                    //por implementar
                    
                } else {
                    System.out.println("No tienes un Pokémon activo para atacar.");
                }
                break;
            case 6:
                System.out.println("Pasas el turno.");
               
                break;
            case 7:
                mostrarMano(actual);
                break;
            default:
                System.out.println("Acción inválida. Por favor, ingrese un número del 1 al 7.");
        }
    } while (accion != 5 && accion != 6);


    resetearTurbo(actual);

    turno++;
} while (jugador1.getMazo().size() > 0 && jugador2.getMazo().size() > 0
        && jugador1.getPuntos() < 3 && jugador2.getPuntos() < 3 && turno < MAX_TURNOS);
}

// CAMBIO (nuevo): apaga la marca de Turbo Velocidad en el activo y el banco
private static void resetearTurbo(Jugador jugador) {
    if (jugador.getPokemonActivo() != null) {
        jugador.getPokemonActivo().setTurboVelocidadUsada(false);
    }
    for (Pokemon p : jugador.getBanco()) {
        if (p != null) {
            p.setTurboVelocidadUsada(false);
        }
    }
}


////////////////crea la mano inicial con almenos un pokemon//////////////////

public static ArrayList<Carta> CrearManoInicial(ArrayList<Carta> mazo){
    ArrayList<Carta> mano;
    do {
        mano = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int num = valorRandom(mazo);
            Carta c = mazo.get(num);
            mano.add(c);
            mazo.remove(num);
        }
        if (!tienePokemon(mano)) {
            System.out.println("Mulligan");
            mazo.addAll(mano);   
        }
    } while (!tienePokemon(mano));
    return mano;
}

//////////////////verificar si tiene pokemon en la mano/////////////////////////////////////

private static boolean tienePokemon(ArrayList<Carta> mano) {
    for (Carta c : mano) {
        if (c.getTipoCarta() == TipoCarta.POKEMON) {
            return true;
        }
    }
    return false;
}

/////////////////mostrar mano del jugador///////////////////

public static void mostrarMano(Jugador jugador) {
    System.out.println("--------------------------------");
    System.out.println("Mano del jugador: " + jugador.getNombre());
    for (int i = 0; i < jugador.getMano().size(); i++) {
        Carta carta = jugador.getMano().get(i);
        System.out.println((i + 1) + ". " + carta.getNombreCarta());
    }
    System.out.println("--------------------------------");
}

////////////////////mostrar datos//////////////////////////

public static void mostrarDatos(Jugador jugador) {
    System.out.println("Pokemon activo: " + (jugador.getPokemonActivo() != null ? jugador.getPokemonActivo().getNombreCarta() : "Ninguno"));
    System.out.println("Energia adjunta al pokemon activo: " + (jugador.getPokemonActivo() != null ? jugador.getPokemonActivo().getEnergiaAcumulada() : 0));
    mostrarBanco(jugador);
    System.out.println("Puntos de premio: " + jugador.getPuntos()+"/3");
        }

/////////////////mostrar el banco////////////////////////////

public static void mostrarBanco(Jugador jugador) {
    boolean vacio = true;
    for (int i = 0; i < jugador.getBanco().length; i++) {
        if (jugador.getBanco()[i] != null) {
            vacio = false;
            break;
        }
    }
    if (vacio) {
        System.out.println("El banco del jugador " + jugador.getNombre() + " está vacío.");
        return;
    }
    System.out.println("Banco del jugador: " + jugador.getNombre());
    for (int i = 0; i < jugador.getBanco().length; i++) {
        if (jugador.getBanco()[i] != null) {
            System.out.println( i+1+"."+ jugador.getBanco()[i].getNombreCarta());
        }
    }
}

////////////////muestra acciones//////////////////////////

public static int mostrarAcciones(Scanner scanner) {
    int accion;
    do {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Adjuntar energía de zona");
        System.out.println("2. Jugar carta de entrenador");
        System.out.println("3. Colocar Pokémon en banco");
        System.out.println("4. Retirar Pokémon activo");
        System.out.println("5. Atacar");
        System.out.println("6. Pasar turno");
        System.out.println("7. Mostrar mano");
        System.out.println("Ingrese el número de la acción que desea realizar:");
        System.out.println("--------------------------------------------------");
        System.out.println("\n");
        accion = scanner.nextInt();
        // CAMBIO: el límite era 6 y la opción 7 nunca llegaba al switch
        if (accion < 1 || accion > 7) {
            System.out.println("Acción inválida. Por favor, ingrese un número del 1 al 7.");
        }
    } while (accion < 1 || accion > 7);
    return accion;
}

/////////////////////////elige el pokemon de la mano//////////////////////////////

public static Pokemon elegirPokemonDeMano(Jugador jugador, Scanner scanner) {
    ArrayList<Integer> posiciones = new ArrayList<>();
    for (int i = 0; i < jugador.getMano().size(); i++) {
        Carta c = jugador.getMano().get(i);
        if (c.getTipoCarta() == TipoCarta.POKEMON) {
            posiciones.add(i);
            System.out.println(posiciones.size() + ". " + c.getNombreCarta());
        }
    }
    if (posiciones.isEmpty()) {
        System.out.println("No tienes Pokémon en la mano.");
        return null;
    }
    System.out.println("Elige el Pokémon:");
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > posiciones.size()) {
        System.out.println("Opción inválida.");
        return null;
    }
    int indiceEnMano = posiciones.get(opcion - 1);
    Pokemon elegido = (Pokemon) jugador.getMano().get(indiceEnMano);
    jugador.getMano().remove(indiceEnMano);
    return elegido;
}

///////////////////colocar pokemon en el banco/////////////////////////////////////

public static void colocarPokemonBanco(Jugador jugador, Scanner scanner) {
    int espacio = -1;
    if(tienePokemon(jugador.getMano())){

    
    for (int i = 0; i < jugador.getBanco().length; i++) {
        if (jugador.getBanco()[i] == null) {
            espacio = i;
            break;
        }
    }
    if (espacio == -1) {
        System.out.println("El banco está lleno.");
        return;
    }
    Pokemon elegido = elegirPokemonDeMano(jugador, scanner);
    if (elegido != null) {
        jugador.getBanco()[espacio] = elegido;
        System.out.println(elegido.getNombreCarta() + " fue colocado en el banco.");
    }
}
else{
    System.out.println("no tienes pokemones disponibles");
}
}

//////////////////////////////colocar pokemon inicial////////////////////////////////////

public static void colocarPokemonInicial(Jugador jugador, Scanner scanner) {
    System.out.println(jugador.getNombre() + ", elige tu Pokémon activo:");
    Pokemon elegido = null;
    while (elegido == null) {
        elegido = elegirPokemonDeMano(jugador, scanner);
    }
    jugador.setPokemonActivo(elegido);
    System.out.println(elegido.getNombreCarta() + " es tu Pokémon activo.");

    for (int i = 0; i < jugador.getBanco().length; i++) {
        System.out.println("¿Quieres colocar un Pokémon en el banco? (1 = sí, 2 = no)");
        if (scanner.nextInt() != 1) {
            break;
        }
        colocarPokemonBanco(jugador, scanner);
    }
}

//////////////////retirar pokemon activo/////////////////////////

public static void retirarPokemonActivo(Jugador jugador, Scanner scanner) {
    Pokemon activo = jugador.getPokemonActivo();
    if (activo == null) {
        System.out.println("No tienes Pokémon activo.");
        return;
    }


    boolean hayBanco = false;
    for (int i = 0; i < jugador.getBanco().length; i++) {
        if (jugador.getBanco()[i] != null) {
            hayBanco = true;
        }

    
    }
    if (!hayBanco) {
        System.out.println("No tienes Pokémon en el banco para reemplazarlo.");
        return;
    }

    if(activo.PuedeRetirada()){
        int opc=ElegirOpcionBanco(jugador, scanner);
        Pokemon nuevoActivo=jugador.getPokemonActivo().retirar(jugador,opc,activo);
        
        jugador.setPokemonActivo(null);
        jugador.setPokemonActivo(nuevoActivo);

        System.out.println(nuevoActivo.getNombreCarta() + " es ahora tu Pokémon activo.");
        } else {
            System.out.println("No tienes energía suficiente para retirar a " + activo.getNombreCarta() + ".");
}
    }


//////////////////////////////////////////////////

public static  int ElegirOpcionBanco(Jugador jugador, Scanner x){
    
    System.out.println("Elige el Pokémon del banco que pasará a activo:");

    mostrarBanco(jugador);

    int opcion = x.nextInt();

    if (opcion < 1 || opcion > jugador.getBanco().length || jugador.getBanco()[opcion - 1] == null) {
        System.out.println("Opción inválida.");
        return ElegirOpcionBanco(jugador, x);
    }

    return opcion;

    }


public static void jugarCartaEntrenador(Jugador jugador, Scanner scanner) {
    boolean hayEntrenador = false;
    System.out.println("Seleccione la carta de entrenador que desea jugar:");
    for (int i = 0; i < jugador.getMano().size(); i++) {
        Carta carta = jugador.getMano().get(i);
        if (carta.getTipoCarta() == TipoCarta.ENTRENADOR) {
            System.out.println((i + 1) + ". " + carta.getNombreCarta());
            hayEntrenador = true;
        }
    }
    if (!hayEntrenador) {
        System.out.println("No tienes ninguna carta de entrenador.");
        return;
    }

    System.out.println("Ingrese el número de la carta que desea jugar:");
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > jugador.getMano().size()) {
        System.out.println("Opción inválida.");
        return;
    }
    Carta cartaSeleccionada = jugador.getMano().get(opcion - 1);
    if (cartaSeleccionada.getTipoCarta() != TipoCarta.ENTRENADOR) {
        System.out.println("La carta seleccionada no es una carta de entrenador.");
        return;
    }

    CartaEntrenador cartaEntrenador = (CartaEntrenador) cartaSeleccionada;
    Pokemon objetivo = null;
    if (cartaEntrenador.requiereObjetivo()) {
        String aviso = cartaEntrenador.getAvisoObjetivo();
        if (!aviso.isEmpty()) {
            System.out.println(aviso);
        }
        objetivo = elegirPokemonEnJuego(jugador, scanner);
        if (objetivo == null) {
            return; // cancelado: la carta sigue en la mano
        }
    }

    if (cartaEntrenador.ActivarCarta(jugador, objetivo)) {
        jugador.getMano().remove(cartaSeleccionada);
        System.out.println("Carta de entrenador " + cartaSeleccionada.getNombreCarta() + " jugada con éxito.");
    }
}


public static void adjuntarEnergia(Jugador jugador, Scanner scanner) {
    if (jugador.getEnergy() < 1) {
        System.out.println("No hay energía disponible para adjuntar.");
        return;
    }
    ArrayList<Pokemon> opciones = new ArrayList<>();
    if (jugador.getPokemonActivo() != null) {
        opciones.add(jugador.getPokemonActivo());
    }
    for (Pokemon p : jugador.getBanco()) {
        if (p != null) {
            opciones.add(p);
        }
    }
    if (opciones.isEmpty()) {
        System.out.println("No tienes Pokémon en juego.");
        return;
    }
    System.out.println("Seleccione a qué Pokémon desea adjuntar la energía:");
    for (int i = 0; i < opciones.size(); i++) {
        System.out.println((i + 1) + ". " + opciones.get(i).getNombreCarta());
    }
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > opciones.size()) {
        System.out.println("Opción inválida.");
        return;
    }
    Pokemon destino = opciones.get(opcion - 1);
    destino.setEnergiaAcumulada(destino.getEnergiaAcumulada() + 1);
    jugador.setEnergy(0);
    System.out.println("Energía adjuntada a " + destino.getNombreCarta() + ". Energía acumulada: " + destino.getEnergiaAcumulada());
}

}

