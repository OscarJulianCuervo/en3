package entrega3;

/*@author JulianCuervo*/
public class Main {
    public static void main(String[] args) {
        // Configura Firebase con tus credenciales
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromFile("ruta-a-tu-archivo-de-credenciales.json"))
                .setDatabaseUrl("https://github.com/OscarJulianCuervo/en3.git")
                .build();
        FirebaseApp.initializeApp(options);

        // Obtiene una referencia a la base de datos
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("usuarios");

        // Escritura de datos
        databaseRef.child("usuario1").setValue("Información del usuario");

        // Lectura de datos
        databaseRef.child("usuario1").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                String userInfo = dataSnapshot.getValue(String.class);
                System.out.println("Información del usuario: " + userInfo);
            }
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error de lectura: " + databaseError.getMessage());
            }
        });

        // Edición de datos
        databaseRef.child("usuario1").setValue("Nueva información del usuario");

        // Borrado de datos
        databaseRef.child("usuario1").removeValue();
    }
}
