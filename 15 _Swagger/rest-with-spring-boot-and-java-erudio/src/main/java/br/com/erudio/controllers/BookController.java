package br.com.erudio.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.BookServices;
import br.com.erudio.services.PersonServices;
import br.com.erudio.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController	
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing books")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@GetMapping(
            produces =  { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all books", description = "Finds all books", 
				tags = {"Book"},
				responses = {
						@ApiResponse(description = "Sucess", responseCode = "200", 
								content = {@Content(
										mediaType = "application/json",
										array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
										)
								}),
						@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
						@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
						@ApiResponse(description = "Not Found", responseCode = "402", content = @Content),
						@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
				})
	public List<BookVO> findAll() 	
	{
		return service.findAll();	
	}

	@GetMapping(value = "/{id}",
            produces =  { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds a book", description = "Finds a book", 
	tags = {"Book"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = BookVO.class))							
					),
			@ApiResponse(description = "No content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "402", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})
	public BookVO findById(@PathVariable Long id) 	
	{
		return service.findById(id);	
	}
	
	@PostMapping(
            consumes =  { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces =  { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Creates a book", description = "Creates a book", 
	tags = {"Book"},
	responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = BookVO.class))							
					),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})

	public BookVO create(@RequestBody BookVO book) 	
	{
		return service.create(book);	
	}		
	
	@PutMapping(
            consumes =  { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces =  { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a book", description = "Updates a book", 
	tags = {"Book"},
	responses = {
			@ApiResponse(description = "Updated", responseCode = "200", 
					content = @Content(schema = @Schema(implementation = BookVO.class))							
					),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "402", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})

	public BookVO update(@RequestBody BookVO book) 	
	{
		return service.update(book);	
	}
	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletes a book", description = "Deletes a book", 
	tags = {"Book"},
	responses = {
			@ApiResponse(description = "No content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "402", content = @Content),
			@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
	})

	public ResponseEntity<?> delete(@PathVariable Long id) 	
	{
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}	
	
	
}
