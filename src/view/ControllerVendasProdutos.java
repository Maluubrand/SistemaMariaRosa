/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MlrVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Maria
 */
public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        
        this.fireTableDataChanged();
    }
    
    public MlrVendasProdutos getBean(int rowIndex) {
        return (MlrVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(MlrVendasProdutos vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MlrVendasProdutos vendasProdutos = (MlrVendasProdutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendasProdutos.getMlrProdutos().getMlrIdProdutos();
        } else if (columnIndex ==1) {
            return vendasProdutos.getMlrProdutos().getMlrNome();
        } else if (columnIndex ==2) {
            return vendasProdutos.getMlrQuantidade();
        } else if (columnIndex ==3) {
            return vendasProdutos.getMlrPrecoUnitario();
        }else if (columnIndex ==4) {
            return vendasProdutos.getMlrPrecoUnitario()*vendasProdutos.getMlrQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Preço Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
