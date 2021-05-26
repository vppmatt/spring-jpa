public class Main {
    public static void main(String[] args) {

        InvoiceDataInterface invoiceData = new InvoiceData();
        InvoiceUtilitiesInterface invoiceUtilities = new InvoiceUtilities();
        invoiceUtilities.setInvoiceData(invoiceData);

        //NOW WE CAN USE THE METHODS OF THE INVOICE UTILITIES CLASS

    }
}
