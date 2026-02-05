import pytest
from math_utils_r import MathUtilsR

@pytest.fixture
def math():
    return MathUtilsR()

def test_add(math):
    assert math.add(2, 3) == 5
    assert math.add(2, -3) == -1
    assert math.add(0, 0) == 0

def test_subtract(math):
    assert math.subtract(3, 2) == 1
    assert math.subtract(2, -3) == 5
    assert math.subtract(0, 0) == 0

def test_multiply(math):
    assert math.multiply(2, 3) == 6
    assert math.multiply(2, -3) == -6
    assert math.multiply(0, 99) == 0

def test_divide_normal(math):
    assert math.divide(6, 3) == 2.0
    assert math.divide(6, -3) == -2.0

def test_divide_by_zero(math):
    assert math.divide(10, 0) == -1.0

