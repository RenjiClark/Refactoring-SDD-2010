package umm.softwaredesign.polygon.controllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import umm.softwaredesign.polygon.view.displaypointstab.PointsPanel;
import umm.softwaredesign.polygon.view.displaypointstab.PointsTable;
import umm.softwaredesign.polygon.view.mainpanelstab.MainPanel;

public class ColorSchemeController implements ItemListener {

    private MainPanel main;
    private PointsTable tablePoints;

    public void addPanels(final MainPanel mainPanel, final PointsTable pointsTable) {
        tablePoints = pointsTable;
        main = mainPanel;
    }

    @Override
    public void itemStateChanged(final ItemEvent event) {
        boolean isSelected = (event.getStateChange() == ItemEvent.SELECTED);
        main.lightColorScheme(isSelected);
        tablePoints.lightColorScheme(isSelected);
    }
}
