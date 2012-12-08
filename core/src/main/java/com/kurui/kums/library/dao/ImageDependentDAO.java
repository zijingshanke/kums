package com.kurui.kums.library.dao;

import java.util.List;

import com.kurui.kums.base.exception.AppException;
import com.kurui.kums.library.ImageDependent;
import com.kurui.kums.library.ImageDependentListForm;
import com.kurui.kums.library.ImageLibrary;
import com.kurui.kums.library.ImageLibraryListForm;

public interface ImageDependentDAO {

	public List list(ImageDependentListForm imageDependentForm) throws AppException;
	public List listViewImageLibrary(ImageLibraryListForm plf) throws AppException;
	
	public void updateImageLibraryTypeByRowId(String tableName,long rowId,long dependentType) throws AppException;

	public void updateImageDependentType(String dependentId,long dependentType) throws AppException;

	public void delete(long id) throws AppException;

	public long save(ImageDependent ImageDependent) throws AppException;

	public long update(ImageDependent ImageDependent) throws AppException;

	public ImageDependent getImageDependentById(long imageDependentId) throws AppException;
	
	public ImageLibrary getCoverImageLibraryByRowId(String tableName,long rowId) throws AppException;

	public List<ImageDependent> getImageDependentList() throws AppException;

	public List<ImageDependent> getValidImageDependentList() throws AppException;
	
	public List<ImageDependent> getImageDependentList(String tableName,long rowId)
			throws AppException;

	public List<ImageLibrary> getImageLibraryList(String tableName,long rowId)
			throws AppException;
	
}
