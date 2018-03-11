# Download Eclipse JEE Oxygen2 para o Debian 9 "Stretch"

Para efetuar o download click [aqui](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/oxygen/2/eclipse-jee-oxygen-2-linux-gtk-x86_64.tar.gz&mirror_id=576), senão vá para a página de downloads [aqui](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen2)

Após efetuar o download, abra o terminal, acesse o local e download e digite:
<!-- language: shell -->
    $ sudo tar -zxvf eclipse* -C /opt/
    $ sudo mv /opt/eclipse*/ /opt/eclipse
    $ sudo wget https://dl2.macupdate.com/images/icons128/11662.png -O /opt/eclipse/eclipse.png
    $ echo -e '[Desktop Entry]\n Version=1.0\n Name=eclipse\n Exec=/opt/eclipse/eclipse\n Icon=/opt/eclipse/eclipse.png\n Type=Application\n Categories=Development' | sudo tee /usr/share/applications/eclipse.desktop
<!-- language: shell -->

Pronto Eclipse instalado.
