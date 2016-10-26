package dialog;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dev on 25.10.16.
 */
public class DialogController extends BorderPane implements Initializable {

    @FXML
    private StackPane stackPane;

    private Viewer viewer;
    private ViewPanel defaultView;
    private Graph graph;

    public void initialize(URL location, ResourceBundle resources) {
        graph = new DefaultGraph("TestGraph");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("AC", "A", "C");
        graph.addEdge("BC", "B", "C");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
                defaultView = viewer.addDefaultView(false);
                viewer.enableAutoLayout();

                javafx.application.Platform.runLater(new Runnable() {
                    @Override public void run() {
                        SwingNode swingNode = new SwingNode();
                        swingNode.setContent(defaultView);
                        stackPane.getChildren().add(swingNode);
                        stackPane.requestLayout();
                        System.out.println("JFX");
                    }
                });
                System.out.println("SWING");
            }
        });
    }

    public void closeViewer() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                viewer.close();
                System.out.println("close");
            }
        });
    }
}
