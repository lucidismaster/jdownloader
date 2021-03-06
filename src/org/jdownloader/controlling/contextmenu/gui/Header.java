package org.jdownloader.controlling.contextmenu.gui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.appwork.swing.MigPanel;
import org.appwork.utils.swing.SwingUtils;
import org.jdownloader.updatev2.gui.LAFOptions;

public class Header extends MigPanel {

    public Header(String layoutManager, ImageIcon icon) {
        super("ins 0 0 1 0", "[]2[][][grow,fill][]0", "[grow,fill]");

        // setBackground(Color.RED);
        // setOpaque(true);

        JLabel lbl = SwingUtils.toBold(new JLabel(layoutManager));
        LAFOptions.getInstance().applyHeaderColorBackground(lbl);
        add(new JLabel(icon), "gapleft 1");
        add(lbl, "height 17!");

        add(Box.createHorizontalGlue());
        setOpaque(true);
        SwingUtils.setOpaque(lbl, false);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (LAFOptions.getInstance().getColorForPanelHeaderLine())));

        setBackground((LAFOptions.getInstance().getColorForPanelHeaderBackground()));

    }
}
