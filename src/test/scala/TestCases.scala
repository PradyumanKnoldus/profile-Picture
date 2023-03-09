import org.scalatest.flatspec.AnyFlatSpec

class TestCases extends AnyFlatSpec {

  "The ProfilePicture program" should "accept a photo that meets the minimum dimension requirement" in {
    assert(ProfilePicture.checkPhoto(50, 50, 50) == "ACCEPTED")
  }

  it should "reject a photo that is too small in at least one dimension" in {
    assert(ProfilePicture.checkPhoto(50, 30, 60) == "UPLOAD ANOTHER")
    assert(ProfilePicture.checkPhoto(50, 60, 30) == "UPLOAD ANOTHER")
  }

  it should "ask to crop picture if image is large" in {
    assert(ProfilePicture.checkPhoto(50, 60, 60) == "CROP IT")
  }
}

