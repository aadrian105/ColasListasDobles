public class App {
    
    public App() {
        //QueueListDouble<Double> prueba = new QueueListDouble<>(4, Double.class);
        QueueListDouble<Integer> prueba = new QueueListDouble<>(6, Integer.class);
        try {
            //prueba.deQueue();
            prueba.enQueue(1);
            prueba.enQueue(2);
            prueba.enQueue(3);
            prueba.enQueue(4);
            prueba.enQueue(5);
            prueba.enQueue(6);
            
            System.out.println("El valor front es: " + prueba.front());
            System.out.println("El valor last es: " + prueba.last());
            
            
            /*if (prueba.removeAll())
                System.out.println("Toda la fila fue removida");*/
            //System.out.println("El valor: " + prueba.deQueue() + " salió");
        } catch (isEmptyException e) {
            System.out.println(e.getMessage());
        } catch (isFullException e) {
            System.out.println(e.getMessage());
        } finally {
            prueba.print();
        }
    }
    
}
