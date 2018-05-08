package de.moritzf.sorting.gui.windows;

import de.moritzf.sorting.gui.components.HeapSortProtocolPane;
import de.moritzf.sorting.logic.sorting.HeapSort;

import javax.swing.*;

public class HeapSortSortingWindow extends AbstractSortingWindow {

    private HeapSortProtocolPane protocolComponent;


    public HeapSortSortingWindow(JFrame parent, HeapSort algorithm) {
        super(parent, algorithm);
        this.protocolComponent = new HeapSortProtocolPane(algorithm);
        this.setProtocolComponent(protocolComponent);
        this.renderProtocol();
    }

    @Override
    protected void renderProtocol() {
        this.protocolComponent.generateProtocol();
    }
}

