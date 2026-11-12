<div align="center">

# ⚡🔥 Pokémon TCG Univalle 💧🔮 

### Simulación por consola del *Pokémon TCG Pocket* — expansión **Genetic Apex**

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Interfaz](https://img.shields.io/badge/Interfaz-Consola-blue)
![Curso](https://img.shields.io/badge/Curso-Programaci%C3%B3n%20Orientada%20a%20Eventos-green)

*Mini Proyecto 1 — Programación Orientada a Eventos · Universidad del Valle (Tuluá)*

</div>

---

## 📖 Descripción

**Pokémon TCG Univalle** es un juego de cartas para dos jugadores que se ejecuta completamente por consola. Modela las mecánicas esenciales de la primera expansión de *Pokémon TCG Pocket*, **Genetic Apex**: armar un mazo, robar cartas, adjuntar energía, jugar cartas de entrenador, mantener un banco de Pokémon, retirar y atacar.

El proyecto está construido con **Java 21 estándar** (sin librerías externas). La partida avanza según las acciones que el jugador elige en cada turno mediante menús numerados, y el código se organiza con clases, herencia y polimorfismo para representar las cartas.

---

## 👥 Integrantes

| Integrante | Código |
|---|---|
| Juan José Palma | 2569091 |
| Sara Sofía Arcila | 2569267 |
| Samuel Zamora | 2569223 |
| Johan Henao | 2569195 |

---

## 🚀 Instrucciones de ejecución

### Requisitos

- **JDK 21** o superior (`java -version` y `javac -version` deben mostrar 21+).
- Una terminal (CMD, PowerShell, Bash, etc.).

### 1. Clonar el repositorio

```bash
git clone https://github.com/<usuario>/<repositorio>.git
cd <repositorio>
```

### 2. Compilar

**Linux / macOS**

```bash
javac -encoding UTF-8 -d bin $(find src -name "*.java")
```

**Windows (PowerShell)**

```powershell
javac -encoding UTF-8 -d bin (Get-ChildItem -Recurse src -Filter *.java).FullName
```

### 3. Ejecutar

```bash
java -cp bin logica.App
```

> 💡 **Con VS Code:** abre la carpeta del proyecto con el *Extension Pack for Java* y ejecuta `App.java` (el código fuente está en `src` y la salida compilada en `bin`).

> 🖥️ Si ves caracteres extraños (emojis o tildes) en la consola de Windows, ejecuta antes `chcp 65001`.

---

## 🎮 Cómo se juega

1. Cada jugador ingresa su **nombre** y elige uno de los **3 mazos predefinidos**.
2. Se reparte una mano inicial de **5 cartas**. Si no hay ningún Pokémon básico, se hace **mulligan** (se devuelve la mano al mazo y se reparte de nuevo).
3. Cada jugador coloca un **Pokémon activo** y, opcionalmente, hasta **2 Pokémon en el banco**.
4. En su turno, el jugador activo puede:

| # | Acción | Descripción |
|:-:|---|---|
| 1 | Adjuntar energía de zona | Adjunta la energía del turno a un Pokémon propio (activo o banco). |
| 2 | Jugar carta de entrenador | Objetos ilimitados; soportes, máximo 1 por turno. |
| 3 | Colocar Pokémon en banco | Si hay espacio disponible. |
| 4 | Retirar Pokémon activo | Pagando el costo de retirada en energías descartadas. |
| 5 | Atacar | Una sola vez por turno; termina el turno. |
| 6 | Pasar turno | Cede el turno al rival. |
| 7 | Mostrar mano | Muestra las cartas de la mano. |

### 🏆 Condiciones de victoria

- Acumular **3 puntos de premio** (1 por Pokémon derrotado, **2** si es Pokémon-ex).
- Que el rival **no pueda robar** carta al inicio de su turno (mazo vacío).
- Que el rival **se quede sin Pokémon** en juego (ni activo ni banco).

### ⚔️ Debilidades (+20 de daño)

| Atacante | Defensor débil |
|:-:|:-:|
| Fuego 🔥 | Agua 💧 |
| Agua 💧 | Fuego 🔥 |
| Eléctrico ⚡ | Agua 💧 |
| Psíquico 🔮 | Incoloro ☆ |

---

## 🃏 Cartas implementadas

### Pokémon

| Pokémon | Tipo | PS | Ataque 1 | Ataque 2 |
|---|:-:|:-:|---|---|
| Pikachu | ⚡ Eléctrico | 60 | Mordisco (1⚡) — 20 | — |
| Charmander | 🔥 Fuego | 60 | Ascuas (1🔥) — 30 | — |
| Squirtle | 💧 Agua | 60 | Placaje (1💧) — 20 | — |
| Jigglypuff | ☆ Incoloro | 70 | Golpe (1☆) — 20 | — |
| Magikarp | 💧 Agua | 30 | Chapoteo (1💧) — 10 | — |
| Snorlax | ☆ Incoloro | 150 | Golpe Cuerpo (3☆) — 100 | — |
| **Mewtwo ex** | 🔮 Psíquico | 150 | Ataque Psíquico (2🔮) — 50 | Psicorrayo (3🔮) — 150 |
| **Zapdos ex** | ⚡ Eléctrico | 130 | Picotazo (1☆) — 30 | Tormenta Eléctrica (3⚡) — 100 |
| **Moltres ex** | 🔥 Fuego | 130 | Aleteo (1☆) — 30 | Danza Infernal (3🔥) — 70 |
| **Articuno ex** | 💧 Agua | 130 | Viento Helado (1💧) — 30 | Ventisca (3💧) — 100 |

### Entrenadores

| Carta | Tipo | Efecto |
|---|:-:|---|
| Investigación del Profesor | Soporte | Descarta tu mano y roba 2 cartas del mazo. |
| Poción | Objeto | Cura 20 PS al Pokémon activo propio. |
| Poké Ball | Objeto | Busca en tu mazo 1 Pokémon básico y ponlo en tu mano. |
| Turbo Velocidad | Objeto | Reduce en 1 el costo de retirada del Pokémon activo este turno. |
| Misty | Soporte | Adjunta hasta 3 energías 💧 a uno de tus Pokémon de Agua. |

---

## 🗂️ Mazos predefinidos

Cada mazo tiene **20 cartas**, con **máximo 2 copias** de cada una y **12 Pokémon básicos**.

| Mazo | Pokémon | Entrenadores |
|:-:|---|---|
| **1** | Articuno ex, Squirtle, Magikarp, Jigglypuff, Snorlax, Mewtwo ex | Misty, Poké Ball, Inv. del Profesor, Turbo Velocidad |
| **2** | Moltres ex, Charmander, Pikachu, Squirtle, Zapdos ex, Snorlax | Poción, Poké Ball, Inv. del Profesor, Turbo Velocidad |
| **3** | Zapdos ex (1), Mewtwo ex (1), Pikachu, Charmander, Magikarp, Jigglypuff, Snorlax | Poción, Poké Ball, Inv. del Profesor, Turbo Velocidad |

---

## 🧱 Estructura del código

```text
src/logica
├── App.java                     → punto de entrada (main)
├── Juego.java                   → flujo de la partida y menús de consola
├── Jugador.java                 → mazo, mano, banco, Pokémon activo, energía y puntos
├── CreadorMazosPDefecto.java    → fábrica de los 3 mazos predefinidos
├── Carta.java                   → clase abstracta base de toda carta
├── TipoCarta.java               → enum: POKEMON, ENTRENADOR
├── TipoPokemon.java             → enum: FUEGO, AGUA, ELECTRICO, PSIQUICO, INCOLORO
├── pokemones/
│   ├── Pokemon.java             → clase abstracta (PS, tipo, energía, ataques, retirada)
│   └── Pikachu, Charmander, Squirtle, Jigglypuff, Magikarp, Snorlax,
│       Mewtwo, Zapdos, Moltres, Articuno
└── CartasEntrenador/
    ├── CartaEntrenador.java     → clase abstracta (soporte/objeto, ActivarCarta)
    └── InvestProfe, Pocion, Pokebola, TurboVelocidad, Misty
```

```text
              Carta  (abstracta)
             /                 \
     Pokemon (abstracta)    CartaEntrenador (abstracta)
       │                          │
  10 Pokémon concretos      5 entrenadores concretos
```

Algunos puntos donde se usa POO:

- **Herencia:** `Carta` → `Pokemon` / `CartaEntrenador` → cartas concretas.
- **Polimorfismo:** cada Pokémon sobrescribe `atacar()` / `atacar2()` y cada entrenador sobrescribe `ActivarCarta()`.
- **Encapsulamiento:** atributos privados o protegidos con getters y setters, por ejemplo en `Jugador` y `Pokemon`.

---

## 🌿 Flujo de trabajo en GitHub

- La entrega final se encuentra en la rama **`main`**.
- Tuvimos ciertas complicaciones con los **Pull Request**.
- Se usan commits pequeños y descriptivos.

---

<div align="center">

Hecho con ☕ y Java por el equipo de **Pokémon TCG Univalle**

</div>
