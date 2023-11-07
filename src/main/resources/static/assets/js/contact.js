
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (contact, status){
            $('#txtEmailEdit').val(contact.email);
            $('#txtFirstnameEdit').val(contact.firstname);
            $('#txtIdEdit').val(contact.id);
            $('#txtLastnameEdit').val(contact.lastname);
            $('#txtMobileEdit').val(contact.mobile);
            $('#txtPhoneEdit').val(contact.phone);
            $('#txtRemarksEdit').val(contact.remarks);
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
        $.get(href, function(contact, status){
            $('#txtEmailDetails').val(contact.email);
            $('#txtFirstnameDetails').val(contact.firstname);
            $('#txtLastnameDetails').val(contact.lastname);
            $('#txtMobileDetails').val(contact.mobile);
            $('#txtPhoneDetails').val(contact.phone);
            $('#lastModifiedByDetails').val(contact.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

});