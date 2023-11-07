
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (vehicleHire, status){
            $('#idEdit').val(vehicleHire.id);
            $('#ddlClientEdit').val(vehicleHire.clientid);

            let dateIn = vehicleHire.dateIn.substr(0,10);
            let dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateInEdit').val(dateIn);
            $('#dateOutEdit').val(dateOut);

            $('#timeInEdit').val(vehicleHire.timeIn);
            $('#timeOutEdit').val(vehicleHire.timeOut);

            $('#ddlLocationEdit').val(vehicleHire.locationid);
            $('#priceEdit').val(vehicleHire.price);
            $('#remarksEdit').val(vehicleHire.remarks);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);
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
        $.get(href, function(vehicleHire, status){
            $('#idDetails').val(vehicleHire.id);
            $('#ddlClientDetails').val(vehicleHire.clientid);

            let dateIn = vehicleHire.dateIn.substr(0,10);
            let dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateInDetails').val(vehicleHire.dateIn);
            $('#dateOutDetails').val(vehicleHire.dateOut);
            $('#ddlLocationDetails').val(vehicleHire.locationid);
            $('#priceDetails').val(vehicleHire.price);
            $('#remarksDetails').val(vehicleHire.remarks);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#lastModifiedByDetails').val(vehicleHire.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(vehicleHire.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

});