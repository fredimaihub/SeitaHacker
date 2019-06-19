public class Principal extends javax.swing.JFrame {
    static Database dados = new Database();
    static Terminal terminal;
    String logText = "Start \r\n";

    public Principal() {
        setLocationRelativeTo(null);
        initComponents();
        main.setVisible(false);
    }

    public static void main(String args[]) {
        dados.montaPessoas();
        terminal = new Terminal(dados.getPessoas());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {
        String nick = nickForm.getText();
        terminal.setNick(nick);
        
        intro.setVisible(false);
        main.setVisible(true);
        log.setText(logText);
    }

    private void deployActionPerformed(java.awt.event.ActionEvent evt) {
        String comando = command.getText()+"";
        
        String retorno = terminal.comand(comando);
        logText += retorno;
        log.setText(logText);
        
        if(retorno.contains("exit")) {
        	main.setVisible(false);
        	log.setText("Start\r\n");
        	intro.setVisible(true);
        }
    }

    private javax.swing.JTextField command;
    private javax.swing.JPanel commandScreen;
    private javax.swing.JPanel data;
    private javax.swing.JButton deploy;
    private javax.swing.JButton iniciar;
    private javax.swing.JPanel intro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea log;
    private javax.swing.JTabbedPane main;
    private javax.swing.JTextField nickForm;

    @SuppressWarnings("unchecked")
    private void initComponents() {

        intro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nickForm = new javax.swing.JTextField();
        iniciar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        main = new javax.swing.JTabbedPane();
        commandScreen = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        command = new javax.swing.JTextField();
        deploy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        data = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        intro.setBackground(new java.awt.Color(51, 51, 51));
        intro.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SeitaHacker");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("<Fredi Maihub | Prog.2 - Dalalana>");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Nick: ");

        nickForm.setBackground(new java.awt.Color(51, 51, 51));
        nickForm.setForeground(new java.awt.Color(204, 204, 204));

        iniciar.setBackground(new java.awt.Color(51, 51, 51));
        iniciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iniciar.setForeground(new java.awt.Color(204, 204, 204));
        iniciar.setText("Iniciar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner.jpg"))); // NOI18N

        javax.swing.GroupLayout introLayout = new javax.swing.GroupLayout(intro);
        intro.setLayout(introLayout);
        introLayout.setHorizontalGroup(
            introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introLayout.createSequentialGroup()
                .addGroup(introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(introLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)))
                    .addGroup(introLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iniciar)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nickForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(introLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel4)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        introLayout.setVerticalGroup(
            introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nickForm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("title");

        main.setBackground(new java.awt.Color(0, 0, 0));

        commandScreen.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("<Fredi Maihub | Prog.2 - Dalalana>");

        command.setBackground(new java.awt.Color(51, 51, 51));
        command.setForeground(new java.awt.Color(204, 204, 204));

        deploy.setBackground(new java.awt.Color(51, 51, 51));
        deploy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deploy.setForeground(new java.awt.Color(204, 204, 204));
        deploy.setText("Deploy");
        deploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deployActionPerformed(evt);
            }
        });

        log.setEditable(false);
        log.setBackground(new java.awt.Color(51, 51, 51));
        log.setColumns(20);
        log.setForeground(new java.awt.Color(204, 204, 204));
        log.setRows(5);
        log.setBorder(null);
        log.setEnabled(false);
        jScrollPane1.setViewportView(log);

        javax.swing.GroupLayout commandScreenLayout = new javax.swing.GroupLayout(commandScreen);
        commandScreen.setLayout(commandScreenLayout);
        commandScreenLayout.setHorizontalGroup(
            commandScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandScreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(121, 121, 121))
            .addGroup(commandScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commandScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(commandScreenLayout.createSequentialGroup()
                        .addComponent(command, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deploy)))
                .addContainerGap())
        );
        commandScreenLayout.setVerticalGroup(
            commandScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(command, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deploy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        main.addTab("Terminal", commandScreen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(intro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(intro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 449, Short.MAX_VALUE))
        );

        pack();
    }
}
