package com.example.miro.domain.history.converter;

import com.example.miro.domain.history.dto.req.HistoryReqDTO;
import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.domain.history.entity.History;
import com.example.miro.domain.userDevice.entity.UserDevice;

public class HistoryConverter {

    public static History toHistory(UserDevice userDevice, HistoryReqDTO.CreateHistoryDTO req) {
        return History.builder()
                .userDevice(userDevice)
                .mode(req.getMode())
                .startedAt(req.getStartedAt())
                .endedAt(req.getEndedAt())
                .status(req.getStatus())
                .duration(req.getDuration())
                .batteryUsage(req.getBatteryUsage())
                .areaSize(req.getAreaSize())
                .build();
    }

    public static HistoryResDTO.HistoryInfoDTO toHistoryInfoDTO(History history) {
        return HistoryResDTO.HistoryInfoDTO.builder()
                .historyId(history.getId())
                .userDeviceId(history.getUserDevice().getId())
                .mode(history.getMode())
                .startedAt(history.getStartedAt())
                .endedAt(history.getEndedAt())
                .status(history.getStatus())
                .duration(history.getDuration())
                .batteryUsage(history.getBatteryUsage())
                .areaSize(history.getAreaSize())
                .build();
    }
}

