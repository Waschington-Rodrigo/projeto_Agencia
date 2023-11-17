/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenciaviagens;

import agencia.DAO.DestinoDAO;
import agencia.DAO.HospedagemDAO;
import agencia.DAO.UsuarioDAO;
import agencia.model.Destino;
import agencia.model.Hospedagem;
import agencia.model.Reserva;
import agencia.model.Usuario;
import static java.lang.System.console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Waschington Rodrigo
 */
public class AgenciaViagens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        String x = "14/12/2023";
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras 
        Date y = sdf1.parse(x);
        System.out.println(sdf1.format(y));
        System.out.println(y);

        Reserva res = new Reserva();
        res.setDataReserva(y);
        res.setIdHospedagem(1);
    }
}
