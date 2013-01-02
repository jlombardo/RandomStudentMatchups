package randomstudentmatchups;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

/**
 * A simple utility class that lets you very simply print an arbitrary
 * component. Just pass the component to the PrintUtilities.printComponent. The
 * component you want to print doesn't need a print method and doesn't have to
 * implement any interface or do anything special at all.
 *
 *
 * If you are going to be printing many times, it is marginally more efficient
 * to first do the following:
 * <PRE>
 * PrintUtilities printHelper = new PrintUtilities(theComponent);
 * </PRE> then later do printHelper.print(). But this is a very tiny difference,
 * so in most cases just do the simpler
 * PrintUtilities.printComponent(componentToBePrinted).
 *
 * @author Marty Hall, http://www.apl.jhu.edu/~hall/java/. 
 * Adopted by Gizzmo Zeuzere, see 
 * http://www.coderanch.com/t/330894/GUI/java/Print-JTextArea
 */
public class PrintUtilities implements Printable {

    private Component componentToBePrinted;

    public static void printComponent(Component c) {
        new PrintUtilities(c).print();
    }

    public PrintUtilities(Component componentToBePrinted) {
        this.componentToBePrinted = componentToBePrinted;
    }

    public void print() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(PrintUtilities.this);
        try {
            if (pj.printDialog()) {
                pj.print();
            }
        } catch (Exception PrintException) {
        }
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        int fontHeight = g2.getFontMetrics().getHeight();
        int fontDesent = g2.getFontMetrics().getDescent();
        double pageHeight = pageFormat.getImageableHeight() - fontHeight;
        double pageWidth = pageFormat.getImageableWidth();
        double headerHeightOnPage = 16.5;
        double oneRowHeight = fontHeight;
        int numRowsOnAPage = (int) ((pageHeight - headerHeightOnPage) / oneRowHeight);
        int totalNumPages = (int) Math.ceil(((double) (((JTextArea)componentToBePrinted).getLineCount()) / numRowsOnAPage));
        System.out.println(totalNumPages);
        double pageHeightForTable = oneRowHeight * numRowsOnAPage;
        double tableWidth = 468;
        double scale = 1;
        if (tableWidth >= pageWidth) {
            scale = pageWidth / tableWidth;
        };
        double tableWidthOnPage = tableWidth * scale;
        if (pageIndex >= totalNumPages) {
            return NO_SUCH_PAGE;
        }
        g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2.drawString("Page: " + (pageIndex + 1), (int) pageWidth / 2 - 35, (int) (pageHeight + fontHeight - fontDesent));
        g2.translate(0f, headerHeightOnPage);
        g2.translate(0f, -pageIndex * pageHeightForTable);
        if (pageIndex + 1 == totalNumPages) {
            int lastRowPrinted = numRowsOnAPage * pageIndex;
            int numRowsLeft = totalNumPages * numRowsOnAPage - lastRowPrinted;
            g2.setClip(0,
                    (int) (pageHeightForTable * pageIndex),
                    (int) Math.ceil(tableWidthOnPage),
                    (int) Math.ceil(oneRowHeight
                    * numRowsLeft));
        } else {
            g2.setClip(0,
                    (int) (pageHeightForTable * pageIndex),
                    (int) Math.ceil(tableWidthOnPage),
                    (int) Math.ceil(pageHeightForTable));
        }
        g2.scale(scale, scale);
        componentToBePrinted.paint(g2);
        g2.scale(1 / scale, 1 / scale);
        g2.translate(0f, pageIndex * pageHeightForTable);
        g2.translate(0f, -headerHeightOnPage);
        g2.setClip(0, 0,
                (int) Math.ceil(tableWidthOnPage),
                (int) Math.ceil(headerHeightOnPage));
        g2.scale(scale, scale);
        return Printable.PAGE_EXISTS;
    }
}