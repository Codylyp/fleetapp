
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (vehicle, status){
            let acDate = vehicle.acquisitionDate.substring(0,10);
            $('#txtAcquisitionDateEdit').val(acDate);
            $('#txtDescriptionEdit').val(vehicle.description);
            $('#ddlEmployeeEdit').val(vehicle.employeeid);
            $('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
            $('#txtIdEdit').val(vehicle.id);
            $('#ddlLocationEdit').val(vehicle.locationid);
            $('#txtNameEdit').val(vehicle.name);
            $('#txtNetWeightEdit').val(vehicle.netWeight);
            $('#txtPowerEdit').val(vehicle.power);

            let regDate = vehicle.registrationDate.substring(0,10);
            $('#txtRegistrationDateEdit').val(regDate);
            $('#txtRemarksEdit').val(vehicle.remarks);
            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);
            $('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
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
        $.get(href, function(vehicle, status){
            $('#txtIdDetails').val(vehicle.id);
            $('#txtDescriptionDetails').val(vehicle.description);
            $('#txtNameDetails').val(vehicle.name);
            $('#txtFuelCapacityDetails').val(vehicle.fuelCapacity);
            $('#txtNetWeightDetails').val(vehicle.netWeight);
            $('#txtPowerDetails').val(vehicle.power);
            $('#lastModifiedByDetails').val(vehicle.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(vehicle.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

    $('.table #photoButton').on('click',function(event) {
        event.preventDefault();

        let href = $(this).attr('href');
        $('#photoModal #vehiclePhoto').attr('src', href);
        $('#photoModal').modal('show');
    });

});