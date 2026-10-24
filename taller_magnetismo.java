// Taller Campo Magnético - Física Eléctrica UNICARIBE
// Opción C: Implementación algorítmica orientada a objetos
// Integrantes: [MARIA CLAUDIA CASTILLO, EDUARDO QUIARO]

class Vector3D {
    double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Producto cruz (v x B)
    public Vector3D productoCruz(Vector3D otro) {
        double cx = (this.y * otro.z) - (this.z * otro.y);
        double cy = (this.z * otro.x) - (this.x * otro.z);
        double cz = (this.x * otro.y) - (this.y * otro.x);
        return new Vector3D(cx, cy, cz);
    }

    // Multiplicación por un escalar (la carga q)
    public Vector3D escalar(double k) {
        return new Vector3D(this.x * k, this.y * k, this.z * k);
    }

    // Magnitud del vector
    public double magnitud() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    @Override
    public String toString() {
        return String.format("(%.2e)i + (%.2e)j + (%.2e)k", x, y, z);
    }
}

public class TallerMagnetismo {
    public static void main(String[] args) {
        // Datos oficiales de la Página 2
        double q_proton = 1.60e-19;
        double q_electron = -1.60e-19;

        Vector3D velocidad = new Vector3D(3.00e-5, 4.00e-5, 0.0);
        Vector3D campo_B = new Vector3D(0.0, 0.0, 0.500);

        // 1. Producto Cruz (v x B)
        Vector3D v_cruz_B = velocidad.productoCruz(campo_B);
        
        // 2. Fuerza para el Protón
        Vector3D F_proton = v_cruz_B.escalar(q_proton);
        
        // 3. Fuerza para el Electrón
        Vector3D F_electron = v_cruz_B.escalar(q_electron);

        // Impresión de resultados
        System.out.println("--- RESULTADOS DEL TALLER (JAVA OOP) ---");
        System.out.println("Producto Cruz (v x B): " + v_cruz_B + " m/s*T");
        System.out.println("\n[PROTÓN]");
        System.out.println("Vector Fuerza: " + F_proton + " N");
        System.out.printf("Magnitud: %.2e N%n", F_proton.magnitud());
        System.out.println("\n[ELECTRÓN]");
        System.out.println("Vector Fuerza: " + F_electron + " N");
        System.out.printf("Magnitud: %.2e N%n", F_electron.magnitud());
    }
}