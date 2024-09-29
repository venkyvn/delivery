package com.digi.delivery.entity.enumerate

enum class BillStatusEnum {
    CREATED,            // Bill has been created
    PENDING_APPROVAL,   // Bill is awaiting approval
    APPROVED,           // Bill has been approved
    IN_WAREHOUSE,       // Bill is in the process of being stored in the warehouse
    STORED,             // Bill has been successfully stored in the warehouse
    IN_TRANSIT,         // Bill is being transported
    DELIVERED,          // Bill has been delivered
    COMPLETED,          // Bill has been fully processed and completed
    CANCELED            // Bill has been canceled
    ;
}
enum class SettlementStatusEnum {
    PENDING,          // Waiting for settlement
    IN_PROGRESS,      // Settlement is currently being processed
    COMPLETED,        // Settlement has been completed successfully
    FAILED,           // Settlement failed
    CANCELED          // Settlement has been canceled
    ;
}
