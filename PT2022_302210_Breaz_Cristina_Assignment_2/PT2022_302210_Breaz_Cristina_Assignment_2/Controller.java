import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller {

    //private SimulationManager m_model;
    private View m_view;

    Controller(View view) {
        // m_model = model;
        m_view = view;

        //... Add listeners to the view.
        view.addListener(new RunListener());
        // view.subListener(new SubListener());
        view.rstListener(new ResetListener());
    }

    class RunListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int userInput = 0;
            int userInput1 = 0;
            int userInput2 = 0;
            int userInput3 = 0;
            int userInput4 = 0;
            int userInput5 = 0;
            int userInput6 = 0;
            String alegere = " ";
            try {
                userInput = Integer.parseInt(m_view.getUserInput());   //nr clienti
                userInput1 = Integer.parseInt(m_view.getUserInput1());  // nr cozi
                userInput2 = Integer.parseInt(m_view.getUserInput2());  // simulation time
                userInput3 = Integer.parseInt(m_view.getUserInput3());   //min arrival time
                userInput4 = Integer.parseInt(m_view.getUserInput4());   //max arrival time
                userInput5 = Integer.parseInt(m_view.getUserInput5());    //min service time
                userInput6 = Integer.parseInt(m_view.getUserInput6());      //max service time
                alegere = (String) m_view.getComboBox().getSelectedItem();


                SimulationManager simulationManager = new SimulationManager(userInput2, userInput6, userInput5, userInput1, userInput, userInput4, userInput3, alegere);
                Thread t = new Thread(simulationManager);
                t.start();

                // m_view.afiseaza(simulationManager.getScheduler().getServers());


            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                  View.getTextArea().setText("");
        }
    }
}
