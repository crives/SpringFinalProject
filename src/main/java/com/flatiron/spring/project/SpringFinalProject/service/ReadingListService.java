package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.CreateReadingListDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.ReadingListByIdDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.ReadingListByUserDTO;
import com.flatiron.spring.project.SpringFinalProject.model.ReadingList;
import com.flatiron.spring.project.SpringFinalProject.repository.ReadingListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    public List<ReadingListByUserDTO> getListByUserId(Long userId) {
        List<ReadingList> readingListByUserId = repository.findAllByUserId(userId);
        return readingListByUserId.stream()
                .map(readingList -> mapper.map(readingList, ReadingListByUserDTO.class))
                .toList();
    }

    public List<ReadingListByIdDTO> getListByListId(Long id) {
        List<ReadingList> readingListByListId = repository.findAllByReadingListId(id);
        return readingListByListId
                .stream()
                .map(readingList -> mapper.map(readingList, ReadingListByIdDTO.class))
                .toList();
    }

    // Create a new reading list for the user with the given ID
    public ReadingListByUserDTO create(CreateReadingListDTO createReadingListDTO) {
        ReadingList readingList = new ReadingList();
        readingList.setName(createReadingListDTO.getName());
        readingList.setUser(userService.getById(createReadingListDTO.getUserId())).orElseThrow(() -> new ValidationException()));
        signup.setActivity(activityService.getActivityById(createSignUpDTO.getActivityId()).orElseThrow(() -> new ValidationException()));
        signup = repository.save(signup);
        return modelMapper.map(signup.getActivity(), ActivityDTO.class);
    }
}
