/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MlrProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 
 */
public class ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public MlrProdutos getBean(int rowIndex) {
        return (MlrProdutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MlrProdutos produtos = (MlrProdutos) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getMlrIdProdutos();
        } else if (columnIndex ==1) {
            return produtos.getMlrNome();        
        } else if (columnIndex ==2) {
            return produtos.getMlrDataValidade();
        } else if (columnIndex ==3) {
            return produtos.getMlrMarca();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Data de Validade";
        } else if ( columnIndex == 3) {
            return "Marca";
        } 
        return "";
    }
}
