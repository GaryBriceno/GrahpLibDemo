package pe.net.lambda.grahplib;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softmoore.android.graphlib.*;

import static java.lang.Math.sin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Graph graph = new Graph.Builder().build();
        grafica(graph);
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Gráfica de los Ejes");
    }

    public void grafica(Graph graph){
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Gráficos");
    }

    public void cuadrado(View v){
        Graph graph = new Graph.Builder()
                .addFunction(xSquared)
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
    }

    public void blanco(View v){
        Graph graph = new Graph.Builder().build();
        grafica(graph);
    }

    public void cuadradoColor(View v){
        Graph graph = new Graph.Builder()
                .addFunction(xSquared, Color.RED)
                .setWorldCoordinates(-5, 5, -2, 20)
                .setXTicks(new double[] {-4, -3, -2, -1, 1, 2, 3, 4})
                .setYTicks(new double[] {2, 4, 6, 8, 10, 12, 14, 16, 18})
                .build();
        grafica(graph);
    }

    public void tresFunciones(View v){
        Graph graph = new Graph.Builder()
                .addFunction(seno, Color.RED)
                .addFunction(cubo, Color.BLUE)
                .addFunction(inversa, Color.GREEN)
                .setWorldCoordinates(-2*Math.PI, 2*Math.PI, -5, 5)
                .setXTicks(new double[] {-3, -1, 1, 3})
                .setYTicks(new double[] {-3, -1, 1, 3})
                .build();
        grafica(graph);
    }

    public void lineaGrafica(View v){
        Point[] points =
                {
                        new Point(-10, 3), new Point(-8, 4),  new Point(5, 2),
                        new Point(0, 0),   new Point(2, -6),  new Point(3,3),
                        new Point(7,5),    new Point(9, 9),   new Point(12, 6)
                };
        Graph graph = new Graph.Builder()
                .addLineGraph(points, Color.RED)
                .build();
        grafica(graph);
    }

    Function xSquared = new Function(){
        public double apply(double x){
            return x*x;
        }
    };

    Function seno = new Function(){
        public double apply(double x){
            return  sin(x);
        }
    };
    Function cubo = new Function(){
        public double apply(double x){
            return  0.1*x*x*x;
        }
    };
    Function inversa = new Function(){
        public double apply(double x){
            return  1/x;
        }
    };
}
