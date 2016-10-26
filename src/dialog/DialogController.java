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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dev on 25.10.16.
 */
public class DialogController extends BorderPane implements Initializable {

    @FXML
    private StackPane stackPane;

    private Viewer viewer;


    public void initialize(URL location, ResourceBundle resources) {
        Graph graph = new DefaultGraph("TestGraph");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("AC", "A", "C");
        graph.addEdge("BC", "B", "C");
        viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        ViewPanel defaultView = viewer.addDefaultView(false);
        viewer.enableAutoLayout();
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(defaultView);
        stackPane.getChildren().add(swingNode);
        System.out.println("graph build");
    }

    public void closeViewer() {
        viewer.close();
    }
}
