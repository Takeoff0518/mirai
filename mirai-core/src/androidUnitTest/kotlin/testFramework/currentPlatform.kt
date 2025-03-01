/*
 * Copyright 2019-2023 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/dev/LICENSE
 */

package net.mamoe.mirai.internal.testFramework

import net.mamoe.mirai.internal.test.AbstractTest
import org.junit.jupiter.api.Test
import kotlin.test.assertIs

actual fun currentPlatform(): Platform = when (System.getenv("mirai.android.sdk.kind")) {
    "jdk" -> Platform.AndroidUnitTestWithJdk
    "adk" -> Platform.AndroidUnitTestWithAdk
    else -> throw IllegalStateException("`mirai.android.sdk.kind` must be `jdk` or `adk`. Ensure you are running tests using Gradle test tasks.")
}

internal class AndroidUnitTestPlatformTest : AbstractTest() {

    @Test
    fun currentPlatformIsAvailable() {
        assertIs<Platform.AndroidUnitTest>(currentPlatform())
    }
}