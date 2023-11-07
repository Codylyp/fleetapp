
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (invoice, status){
            $('#idEdit').val(invoice.id);
            $('#ddlClientEdit').val(invoice.clientid);

            let invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#remarksEdit').val(invoice.remarks);
            $("#editModal").modal('show');
        });

        // $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();

        let href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal('show');

        // $('#deleteModal').modal();
    });

    $('table #detailsButton').on('click',function(event) {
        event.preventDefault();

        let href= $(this).attr('href');
        $.get(href, function(invoice, status){
            $('#idDetails').val(invoice.id);
            $('#ddlClientDetails').val(invoice.clientid);

            let invoiceDate = invoice.invoiceDate(0,10);
            $('#invoiceDateDetails').val(invoiceDate);
            $('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
            $('#remarksDetails').val(invoice.remarks);
            $('#lastModifiedByDetails').val(invoice.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

});