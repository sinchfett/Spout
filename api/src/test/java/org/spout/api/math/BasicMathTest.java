/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011 Spout LLC <http://www.spout.org/>
 * Spout is licensed under the Spout License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spout is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.spout.api.math.GenericMath.floor;
import static org.spout.api.math.GenericMath.mean;
import static org.spout.api.math.GenericMath.roundUpPow2;
import static org.spout.api.math.TestUtils.eps;

public final class BasicMathTest {
	@SuppressWarnings ("unused")
	private static final double fastError = 0.0015;

	@Test
	public void testMean() {
		int[] intTestValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int intTestResult = 8;
		double[] doubleTestValues = new double[intTestValues.length];
		double doubleTestResult = intTestResult + 0.03;//Some arbitrary value, doesn't matter!

		for (int i = 0; i < intTestValues.length; i++) {
			doubleTestValues[i] = intTestValues[i] + 0.03;
		}

		assertEquals(intTestResult, mean(intTestValues));
		assertEquals(doubleTestResult, mean(doubleTestValues), eps);
	}

	@Test
	public void testRoundUpPow2() {
		assertEquals(1, roundUpPow2(-1));
		assertEquals(1, roundUpPow2(0));
		assertEquals(16, roundUpPow2(9));
		assertEquals(8, roundUpPow2(8));
		assertEquals(4096, roundUpPow2(2050));
	}

	@Test
	public void testFloor() {
		assertEquals(1, floor(1.5f));
		assertEquals(1, floor(1.5));
		assertEquals(59, floor(59.987));
		assertEquals(59, floor(59.987f));
		assertEquals(0, floor(0.9));
		assertEquals(0, floor(0.9f));
	}
}
