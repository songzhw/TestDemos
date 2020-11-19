#import <Foundation/Foundation.h>
#import "HttpEngine.h"

NS_ASSUME_NONNULL_BEGIN

@interface LoginLogic : NSObject
@property (nonatomic) HttpEngine* http;
-(NSString*) loginWithName:(NSString*)name pwd:(NSString*)pwd;
@end

NS_ASSUME_NONNULL_END
