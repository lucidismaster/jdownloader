package org.jdownloader.gui.views.linkgrabber.properties;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import jd.controlling.linkcrawler.CrawledLink;
import jd.controlling.linkcrawler.CrawledPackage;
import jd.controlling.packagecontroller.AbstractNode;

import org.appwork.swing.MigPanel;
import org.appwork.swing.components.ExtButton;
import org.appwork.utils.ImageProvider.ImageProvider;
import org.appwork.utils.swing.SwingUtils;
import org.jdownloader.actions.AppAction;
import org.jdownloader.gui.translate._GUI;
import org.jdownloader.images.NewTheme;
import org.jdownloader.updatev2.gui.LAFOptions;

public class LinkgrabberPropertiesHeader extends MigPanel {

    private JButton   bt;
    private ExtButton options;
    private JLabel    lbl;
    private JLabel    icon;

    public LinkgrabberPropertiesHeader() {
        super("ins 0 0 1 0", "[]2[][grow,fill][]0", "[grow,fill]");

        // setBackground(Color.RED);
        // setOpaque(true);

        lbl = SwingUtils.toBold(new JLabel(""));
        LAFOptions.getInstance().applyHeaderColorBackground(lbl);
        add(icon = new JLabel(NewTheme.I().getIcon("download", 16)), "gapleft 1");
        add(lbl, "height 17!");

        options = new ExtButton(new AppAction() {
            {
                //

                setSmallIcon(new ImageIcon(ImageProvider.merge(NewTheme.I().getImage("exttable/columnButton", -1), NewTheme.I().getImage("popupButton", -1), 0, 0, 16, 4)));
                setTooltipText(_GUI._.LinkgrabberOverViewHeader_LinkgrabberOverViewHeader_settings_tooltip_());
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // JPopupMenu pu = new JPopupMenu();
                // CheckboxMenuItem total = new CheckboxMenuItem(_GUI._.OverViewHeader_actionPerformed_total_(),
                // CFG_GUI.OVERVIEW_PANEL_TOTAL_INFO_VISIBLE);
                // CheckboxMenuItem filtered = new CheckboxMenuItem(_GUI._.OverViewHeader_actionPerformed_visible_only_(),
                // CFG_GUI.OVERVIEW_PANEL_VISIBLE_ONLY_INFO_VISIBLE);
                // CheckboxMenuItem selected = new CheckboxMenuItem(_GUI._.OverViewHeader_actionPerformed_selected_(),
                // CFG_GUI.OVERVIEW_PANEL_SELECTED_INFO_VISIBLE);
                // pu.add(new CheckboxMenuItem(_GUI._.OverViewHeader_actionPerformed_smart_(), CFG_GUI.OVERVIEW_PANEL_SMART_INFO_VISIBLE,
                // total, filtered, selected));
                //
                // pu.add(new JSeparator(JSeparator.HORIZONTAL));
                // pu.add(total);
                // pu.add(filtered);
                // pu.add(selected);
                // int[] insets = LAFOptions.getInstance().getPopupBorderInsets();
                //
                // Dimension pref = pu.getPreferredSize();
                // // pref.width = positionComp.getWidth() + ((Component)
                // // e.getSource()).getWidth() + insets[1] + insets[3];
                // // pu.setPreferredSize(new Dimension(optionsgetWidth() + insets[1] + insets[3], (int) pref.getHeight()));
                //
                // pu.show(options, -insets[1], -pu.getPreferredSize().height + insets[2]);
            }
        });
        options.setRolloverEffectEnabled(true);
        // add(options, "height 17!,width 24!");
        add(Box.createHorizontalGlue());
        setOpaque(true);
        SwingUtils.setOpaque(lbl, false);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, (LAFOptions.getInstance().getColorForPanelHeaderLine())));

        setBackground((LAFOptions.getInstance().getColorForPanelHeaderBackground()));
        bt = new JButton(NewTheme.I().getIcon("close", -1)) {

            public void setBounds(int x, int y, int width, int height) {
                super.setBounds(x + 4, y, width, height);
            }

        };
        bt.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bt.setIcon(NewTheme.I().getIcon("close", -1));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bt.setIcon(NewTheme.I().getIcon("close.on", -1));

            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        bt.setBorderPainted(false);
        bt.setContentAreaFilled(false);
        bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onCloseAction();
            }
        });
        add(bt, "width 17!,height 17!");
    }

    protected void onCloseAction() {
    }

    public Dimension getPreferredSize() {
        Dimension ret = super.getPreferredSize();

        return ret;
    }

    public Dimension getSize() {
        Dimension ret = super.getSize();

        return ret;
    }

    public void update(AbstractNode objectbyRow) {
        if (objectbyRow instanceof CrawledPackage) {
            CrawledPackage pkg = (CrawledPackage) objectbyRow;
            icon.setIcon(NewTheme.I().getIcon("package_open", 16));
            lbl.setText(_GUI._.LinkgrabberPropertiesHeader_update_package(pkg.getName()));
        } else if (objectbyRow instanceof CrawledLink) {
            CrawledLink link = (CrawledLink) objectbyRow;
            icon.setIcon(link.getIcon());
            lbl.setText(_GUI._.LinkgrabberPropertiesHeader_update_link(link.getName()));
        }
    }
}