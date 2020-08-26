//

#import <XCTest/XCTest.h>

@interface iOSTest101Tests : XCTestCase

@end

@implementation iOSTest101Tests

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
      NSUInteger sum = 1 + 2;
      XCTAssertEqual(sum, 3);
    }];
}

@end
