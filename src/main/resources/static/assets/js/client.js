
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (client, status){
            $('#txtAddressEdit').val(client.address);
            $('#txtCityEdit').val(client.city);
            $('#ddlCountryEdit').val(client.countryid);
            $('#txtDetailsEdit').val(client.details);
            $('#txtEmailEdit').val(client.email);
            $('#txtIdEdit').val(client.id);
            $('#txtMobileEdit').val(client.mobile);
            $('#txtNameEdit').val(client.name);
            $('#txtPhoneEdit').val(client.phone);
            $('#ddlStateEdit').val(client.stateid);
            $('#txtWebsiteEdit').val(client.website);
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
        $.get(href, function(client, status){
            $('#nameDetails').val(client.name);
            $('#websiteDetails').val(client.website);
            $('#emailDetails').val(client.email);
            $('#addressDetails').val(client.address);
            $('#phoneDetails').val(client.phone);
            $('#lastModifiedByDetails').val(client.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

});