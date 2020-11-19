#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface HttpEngine : NSObject
-(NSString*) requestWithUrl: (NSString*) url;
@end

NS_ASSUME_NONNULL_END
