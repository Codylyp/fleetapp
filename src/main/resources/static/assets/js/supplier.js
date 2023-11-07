
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (supplier, status){
            $('#txtAddressEdit').val(supplier.address);
            $('#txtCityEdit').val(supplier.city);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#txtDetailsEdit').val(supplier.details);
            $('#txtEmailEdit').val(supplier.email);
            $('#txtIdEdit').val(supplier.id);
            $('#txtMobileEdit').val(supplier.mobile);
            $('#txtNameEdit').val(supplier.name);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#txtWebsiteEdit').val(supplier.website);
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
        $.get(href, function(supplier, status){
            $('#nameDetails').val(supplier.name);
            $('#websiteDetails').val(supplier.website);
            $('#emailDetails').val(supplier.email);
            $('#addressDetails').val(supplier.address);
            $('#phoneDetails').val(supplier.phone);
            $('#lastModifiedByDetails').val(supplier.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

});