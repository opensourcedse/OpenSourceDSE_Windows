package dsePackage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class CustomizationUI extends javax.swing.JFrame {

    public CustomizationUI() {
        initComponents();
        try {
        	File fXmlFile = new File("optionFile.xml");
        	if(fXmlFile.exists()){
        		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            	Document doc = dBuilder.parse(fXmlFile);
            	doc.getDocumentElement().normalize();
            	NodeList nList=doc.getElementsByTagName("reIndexInterval");
            	Node nNode = (Node) nList.item(0);
            	jComboBoxInterval.setSelectedItem(nNode.getTextContent());
            	nList = doc.getElementsByTagName("hotKey");
            	nNode = (Node) nList.item(0);
            	if(nNode.getTextContent().equalsIgnoreCase("true")){
            		jCheckBoxHotKey.setSelected(true);
            	}
            	else{
            		jCheckBoxHotKey.setSelected(false);
            	}
            	nList = doc.getElementsByTagName("criticalDirectory");
            	nNode = (Node) nList.item(0);
            	Element eElement = (Element) nNode;
            	nList= eElement.getElementsByTagName("directory");
        	    for(int i=0;i<nList.getLength();i++){
        	    	Node nValue = (Node) nList.item(i);
        	    	modelCritical.addElement(nValue.getTextContent());
        	    } 
                nList = doc.getElementsByTagName("notIndexedDirectory");
            	nNode = (Node) nList.item(0);
            	eElement = (Element) nNode;
            	nList= eElement.getElementsByTagName("directory");
        	    for(int i=0;i<nList.getLength();i++){
        	    	Node nValue = (Node) nList.item(i);
        	    	modelNotIndex.addElement(nValue.getTextContent());
        	    } 
        	}
        }catch(Exception e){System.out.println(e.getMessage());}

    }
    
    private void initComponents() {

    	modelCritical = new DefaultListModel();
        modelNotIndex = new DefaultListModel();
        jFileChooser  = new JFileChooser();
        jLabelCritical = new JLabel();
        jScrollPane1 = new JScrollPane();
        jListCritical = new JList(modelCritical);
        jButtonCritical = new JButton();
        jScrollPane2 = new JScrollPane();
        jListNotIndex = new JList(modelNotIndex);
        jButtonNotIndex = new JButton();
        jLabelNotIndex = new JLabel();
        jLabelInterval = new JLabel();
        jComboBoxInterval = new JComboBox();
        jButtonReIndex = new JButton();
        jCheckBoxHotKey = new JCheckBox();
        jButtonSave = new JButton();
        jButtonCancel = new JButton();
        jLabelInfo=new JLabel("Double click the directory name to remove from the list.");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customization Window");
        
        jButtonCritical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCriticalMouseClicked(evt);
            }
        });
        jButtonNotIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNotIndexMouseClicked(evt);
            }
        });
        jLabelCritical.setText("Critical Directories:");

        jScrollPane1.setViewportView(jListCritical);

        jButtonCritical.setText("Add Critcal Directory");

        jScrollPane2.setViewportView(jListNotIndex);

        jButtonNotIndex.setText("Add  Directory");

        jLabelNotIndex.setText("Directories Not to be Indexed:");

        jLabelInterval.setText("Re-Indexing Interval:");

        jComboBoxInterval.setModel(new DefaultComboBoxModel(new String[] { "1 Week", "2 Week", "3 Week", "4 Week" }));

        jButtonReIndex.setText("Re-Index Now");

        jCheckBoxHotKey.setText("  Enable HotKey");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        jButtonSave.setText("Save");
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseClicked(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelMouseClicked(evt);
            }
        });
        
        jListCritical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCriticalMouseClicked(evt);
            }
        });
        
        jListNotIndex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListNotIndexMouseClicked(evt);
            }
        });
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 361, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(jLabelInterval)
                            .add(18, 18, 18)
                            .add(jComboBoxInterval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(18, 18, 18)
                            .add(jButtonReIndex, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(jLabelCritical)
                            .add(47, 47, 47)
                            .add(jButtonCritical))))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(56, 56, 56)
                        .add(jCheckBoxHotKey, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jLabelNotIndex)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonNotIndex, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
            	.addContainerGap()
            	.add(jLabelInfo)
            	.addContainerGap(100, Short.MAX_VALUE)
                .add(jButtonSave)
                .add(18, 18, 18)
                .add(jButtonCancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelCritical)
                    .add(jButtonCritical)
                    .add(jLabelNotIndex)
                    .add(jButtonNotIndex))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane2)
                    .add(jScrollPane1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelInterval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jComboBoxInterval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonReIndex)
                    .add(jCheckBoxHotKey))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                	.add(jLabelInfo)
                	.add(jButtonCancel)
                    .add(jButtonSave))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void jListCriticalMouseClicked(java.awt.event.MouseEvent evt) {
    	if(evt.getClickCount()==2){
    		modelCritical.removeElementAt(jListCritical.getSelectedIndex());
    	}
    }
    
    private void jListNotIndexMouseClicked(java.awt.event.MouseEvent evt) {
    	if(evt.getClickCount()==2){
    		modelNotIndex.removeElementAt(jListNotIndex.getSelectedIndex());
    	}
    }
    
    private void jButtonCriticalMouseClicked(java.awt.event.MouseEvent evt) {
        int check = jFileChooser.showOpenDialog(this);
		if(check == jFileChooser.APPROVE_OPTION) {
			String file = jFileChooser.getSelectedFile().toString();
			if(!modelNotIndex.contains(file))  {
				if(!modelCritical.contains(file))
					modelCritical.addElement(file);
				else 
					JOptionPane.showMessageDialog(this, "The Directory already exists");
			}
			else 
				JOptionPane.showMessageDialog(this, "The Directory already exists in the other list");
			
		}
    }
    private void jButtonNotIndexMouseClicked(java.awt.event.MouseEvent evt) {
        int check = jFileChooser.showOpenDialog(this);
		if(check == jFileChooser.APPROVE_OPTION) {
			String file = jFileChooser.getSelectedFile().toString();
			if(!modelCritical.contains(file))  {
				if(!modelNotIndex.contains(file))
					modelNotIndex.addElement(file);
				else 
					JOptionPane.showMessageDialog(this, "The Directory already exists");
			}
			else 
				JOptionPane.showMessageDialog(this, "The Directory already exists in the other list");	
		}
    }
    
    private void jButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {
    	try {
         createXML();
    	}catch(Exception e){}
    }

    private void jButtonCancelMouseClicked(java.awt.event.MouseEvent evt) {
    	System.exit(0);
    }
    
    private void createXML() throws Exception{
    	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    	Document document = documentBuilder.newDocument();
    	Element rootElement = document.createElement("optionFile");
    	document.appendChild(rootElement);
    	Element em = document.createElement("reIndexInterval");
        em.appendChild(document.createTextNode(jComboBoxInterval.getSelectedItem().toString()));
        rootElement.appendChild(em);
        em = document.createElement("hotKey");
        if(jCheckBoxHotKey.isSelected()) {
        	em.appendChild(document.createTextNode("true"));
        }
        else{
        	em.appendChild(document.createTextNode("false"));
        }
        rootElement.appendChild(em);
        em = document.createElement("criticalDirectory");
        rootElement.appendChild(em);
        for(int i=0;i<modelCritical.getSize();i++) {
        	Element em1 = document.createElement("directory");
        	em1.appendChild(document.createTextNode(modelCritical.elementAt(i).toString()));
        	em.appendChild(em1);
        }
        em = document.createElement("notIndexedDirectory");
        rootElement.appendChild(em);
        for(int i=0;i<modelNotIndex.getSize();i++) {
        	Element em1 = document.createElement("directory");
        	em1.appendChild(document.createTextNode(modelNotIndex.elementAt(i).toString()));
        	em.appendChild(em1);
        }
        
        StringWriter sw = new StringWriter();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result =  new StreamResult(sw);
        transformer.transform(source, result);
        FileWriter fWriter = new FileWriter("optionFile.xml");
		BufferedWriter bufferWriter = new BufferedWriter(fWriter);
		bufferWriter.write(sw.toString());
		bufferWriter.close();
    }

    private JFileChooser jFileChooser;
    private DefaultListModel modelCritical;
    private DefaultListModel modelNotIndex;
    private JButton jButtonCritical;
    private JButton jButtonNotIndex;
    private JButton jButtonReIndex;
    private JCheckBox jCheckBoxHotKey;
    private JComboBox jComboBoxInterval;
    private JLabel jLabelCritical;
    private JLabel jLabelNotIndex;
    private JLabel jLabelInterval;
    private JList jListCritical;
    private JList jListNotIndex;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JButton jButtonCancel;
    private JButton jButtonSave;
    private JLabel jLabelInfo;
}
